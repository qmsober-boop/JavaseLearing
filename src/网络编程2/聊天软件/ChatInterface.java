package 网络编程2.聊天软件;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ChatInterface extends JFrame {
    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;
    private JLabel onlineCountLabel;
    private JList<String> userList;
    private DefaultListModel<String> listModel;
    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;
    private String userName;
    private Thread receiveThread;

    public ChatInterface(String userName, Socket socket) {
        this.userName = userName;
        this.socket = socket;
        try {
            OutputStream os = socket.getOutputStream();
            dos = new DataOutputStream(os);
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        initializeGUI();
        setVisible(true);
        startMessageReceiver();
    }

    private void initializeGUI() {
        setTitle("聊天室 - " + userName);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // 设置主面板布局
        setLayout(new BorderLayout());
        
        // 创建顶部面板（在线用户信息）
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(240, 240, 240));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        onlineCountLabel = new JLabel("在线用户: 0人");
        onlineCountLabel.setFont(new Font("楷体", Font.BOLD, 14));
        onlineCountLabel.setForeground(new Color(70, 130, 180));
        topPanel.add(onlineCountLabel, BorderLayout.WEST);
        
        JLabel welcomeLabel = new JLabel("欢迎, " + userName + "!");
        welcomeLabel.setFont(new Font("楷体", Font.BOLD, 14));
        welcomeLabel.setForeground(new Color(34, 139, 34));
        topPanel.add(welcomeLabel, BorderLayout.EAST);
        
        add(topPanel, BorderLayout.NORTH);
        
        // 创建中央面板（聊天区域和用户列表）
        JPanel centerPanel = new JPanel(new BorderLayout());
        
        // 聊天区域
        JPanel chatPanel = new JPanel(new BorderLayout());
        chatPanel.setBorder(BorderFactory.createTitledBorder("聊天大厅"));
        
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("楷体", Font.PLAIN, 14));
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setBackground(new Color(253, 253, 253));
        
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        chatScrollPane.setPreferredSize(new Dimension(500, 400));
        chatPanel.add(chatScrollPane, BorderLayout.CENTER);
        
        // 用户列表
        JPanel userPanel = new JPanel(new BorderLayout());
        userPanel.setBorder(BorderFactory.createTitledBorder("在线用户"));
        userPanel.setPreferredSize(new Dimension(200, 0));
        
        listModel = new DefaultListModel<>();
        userList = new JList<>(listModel);
        userList.setFont(new Font("楷体", Font.PLAIN, 12));
        userList.setBackground(new Color(253, 253, 253));
        
        JScrollPane userScrollPane = new JScrollPane(userList);
        userPanel.add(userScrollPane, BorderLayout.CENTER);
        
        centerPanel.add(chatPanel, BorderLayout.CENTER);
        centerPanel.add(userPanel, BorderLayout.EAST);
        
        add(centerPanel, BorderLayout.CENTER);
        
        // 创建底部面板（消息输入）
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        messageField = new JTextField();
        messageField.setFont(new Font("楷体", Font.PLAIN, 14));
        messageField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        
        sendButton = new JButton("发送");
        sendButton.setFont(new Font("楷体", Font.BOLD, 14));
        sendButton.setBackground(new Color(70, 130, 180));
        sendButton.setForeground(Color.WHITE);
        sendButton.setFocusPainted(false);
        sendButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        
        // 添加按钮悬停效果
        sendButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sendButton.setBackground(new Color(100, 149, 237));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sendButton.setBackground(new Color(70, 130, 180));
            }
        });
        
        bottomPanel.add(messageField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);
        
        add(bottomPanel, BorderLayout.SOUTH);
        
        // 添加事件监听器
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        

        
        // 添加窗口关闭监听器
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                try {
                    if (dos != null) {
                        dos.writeInt(4); // 发送退出命令
                        dos.flush();
                    }
                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        });
    }

    private void sendMessage()  {
        String message = messageField.getText().trim();
        if (!message.isEmpty() && dos != null) {
            try {
                dos.writeInt(2); // 发送消息命令
                dos.writeUTF(message);
                dos.flush();
                messageField.setText("");
                messageField.requestFocus();
            } catch (IOException e) {
                e.printStackTrace();
                appendMessage("发送消息失败: " + e.getMessage(), Color.RED);
            }
        }
    }
//1,更新用户列表   2,接收消息  3,发送大厅信息  4,接受大厅信息 5,发送好友信息 6,接受好友信息 7退出
    private void startMessageReceiver() {
        receiveThread = new Thread(() -> {
            try {
                while (true) {
                    int cmd = dis.readInt();
                    switch (cmd)
                    {
                        case 1:
                            updateUserList();
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            String messageGet = dis.readUTF();
                            appendMessage(messageGet, Color.BLACK);
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            break;
                    }
                }
            } catch (IOException e) {
                if (!socket.isClosed()) {
                    appendMessage("与服务器断开连接: " + e.getMessage(), Color.RED);
                }
            }
        });
        receiveThread.start();
    }

    private void updateUserList() {
        try {
            int userCount = dis.readInt();
            listModel.clear();
            
            SwingUtilities.invokeLater(() -> {
                onlineCountLabel.setText("在线用户: " + userCount + "人");
            });
            
            for (int i = 0; i < userCount; i++) {
                String userName = dis.readUTF();
                listModel.addElement(userName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void appendMessage(String message, Color color) {
        SwingUtilities.invokeLater(() -> {
            chatArea.setForeground(color);
            chatArea.append(message + "\n");
            chatArea.setForeground(Color.BLACK);
            chatArea.setCaretPosition(chatArea.getDocument().getLength());
        });
    }

}
