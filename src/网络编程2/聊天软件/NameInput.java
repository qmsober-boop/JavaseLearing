package 网络编程2.聊天软件;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class NameInput extends JFrame {
    private JTextField nameField;
    private JLabel greetingLabel;
    public NameInput() {
        // 设置窗口标题
        setTitle("名称输入");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 居中显示
        
        // 使用无布局管理器，手动定位组件
        setLayout(null);
        
        // 设置窗口背景色
        getContentPane().setBackground(new Color(245, 250, 250));
        
        // 创建标签
        JLabel promptLabel = new JLabel("请输入您的名称:");
        promptLabel.setFont(new Font("楷体", Font.PLAIN, 23));
        promptLabel.setBounds(100, 50, 300, 30);
        add(promptLabel);
        
        // 创建文本框
        nameField = new JTextField();
        nameField.setFont(new Font("楷体", Font.PLAIN, 23));
        nameField.setBounds(50, 90, 300, 35);
        nameField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(125, 21, 21), 1),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        add(nameField);
        
        // 创建按钮
        JButton submitButton = new JButton("确定");
        submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        submitButton.setBackground(new Color(125, 21, 21));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        submitButton.setBounds(150, 150, 100, 40);
        // 添加悬停效果
        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitButton.setBackground(new Color(138, 115, 21));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                submitButton.setBackground(new Color(70, 130, 180));
            }
        });
        add(submitButton);
        
        // 创建问候标签（初始隐藏）
        greetingLabel = new JLabel("");
        greetingLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
        greetingLabel.setForeground(new Color(34, 139, 34));
        greetingLabel.setBounds(50, 190, 300, 30);
        greetingLabel.setVisible(false);
        add(greetingLabel);
        
        // 按钮点击事件
        submitButton.addActionListener(new ActionListener() {
            public Socket login() {
                try {
                    Socket socket = new Socket(Consent.HOST, Consent.PORT);
                    OutputStream os = socket.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(os);
                    dos.writeInt(1);
                    dos.writeUTF(nameField.getText());
                    dos.flush();
                    return socket;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }

            }
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                if (!name.isEmpty()) {
                    Socket socket = login();
                    if (socket != null && !socket.isClosed()) {
                        new ChatInterface(name, socket);
                        NameInput.this.dispose();
                    } else {
                        greetingLabel.setText("连接服务器失败，请重试");
                        greetingLabel.setForeground(Color.RED);
                        greetingLabel.setVisible(true);
                    }
                } else {
                    greetingLabel.setText("请输入有效的名称");
                    greetingLabel.setForeground(Color.RED);
                    greetingLabel.setVisible(true);
                }
            }
        });
        
        // 回车键提交
        nameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitButton.doClick();
            }
        });
    }



     static void main(String[] args) throws IOException {
        // 使用系统外观

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }


        // 在事件调度线程上创建和显示GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NameInput().setVisible(true);
            }
        });
    }
}