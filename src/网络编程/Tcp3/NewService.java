package 网络编程.Tcp3;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class NewService extends  Thread{
    private Socket socket;
    public NewService(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OutputStream out = socket.getOutputStream();
            PrintStream ps = new PrintStream(out);
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html;charset=UTF-8");
            ps.println();
            ps.println("<!DOCTYPE html>\n" +
                    "<html lang=\"zh-CN\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>全网比价 - 购物搜索</title>\n" +
                    "    <style>\n" +
                    "        * {\n" +
                    "            margin: 0;\n" +
                    "            padding: 0;\n" +
                    "            box-sizing: border-box;\n" +
                    "        }\n" +
                    "\n" +
                    "        body {\n" +
                    "            font-family: -apple-system, BlinkMacSystemFont, \"Segoe UI\", \"Microsoft YaHei\", sans-serif;\n" +
                    "            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);\n" +
                    "            min-height: 100vh;\n" +
                    "            padding: 40px 20px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .container {\n" +
                    "            max-width: 1200px;\n" +
                    "            margin: 0 auto;\n" +
                    "        }\n" +
                    "\n" +
                    "        .search-box {\n" +
                    "            background: white;\n" +
                    "            border-radius: 50px;\n" +
                    "            padding: 8px;\n" +
                    "            display: flex;\n" +
                    "            box-shadow: 0 10px 40px rgba(0,0,0,0.2);\n" +
                    "            margin-bottom: 40px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .search-box input {\n" +
                    "            flex: 1;\n" +
                    "            border: none;\n" +
                    "            padding: 15px 25px;\n" +
                    "            font-size: 18px;\n" +
                    "            outline: none;\n" +
                    "            border-radius: 50px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .search-box button {\n" +
                    "            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);\n" +
                    "            border: none;\n" +
                    "            color: white;\n" +
                    "            padding: 15px 40px;\n" +
                    "            font-size: 18px;\n" +
                    "            border-radius: 50px;\n" +
                    "            cursor: pointer;\n" +
                    "            transition: transform 0.2s;\n" +
                    "        }\n" +
                    "\n" +
                    "        .search-box button:hover {\n" +
                    "            transform: scale(1.05);\n" +
                    "        }\n" +
                    "\n" +
                    "        .platforms {\n" +
                    "            display: flex;\n" +
                    "            justify-content: center;\n" +
                    "            gap: 20px;\n" +
                    "            margin-bottom: 30px;\n" +
                    "            flex-wrap: wrap;\n" +
                    "        }\n" +
                    "\n" +
                    "        .platform-tag {\n" +
                    "            background: rgba(255,255,255,0.2);\n" +
                    "            color: white;\n" +
                    "            padding: 8px 20px;\n" +
                    "            border-radius: 20px;\n" +
                    "            font-size: 14px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .results {\n" +
                    "            display: grid;\n" +
                    "            grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));\n" +
                    "            gap: 20px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .product-card {\n" +
                    "            background: white;\n" +
                    "            border-radius: 16px;\n" +
                    "            overflow: hidden;\n" +
                    "            box-shadow: 0 4px 20px rgba(0,0,0,0.1);\n" +
                    "            transition: transform 0.3s, box-shadow 0.3s;\n" +
                    "        }\n" +
                    "\n" +
                    "        .product-card:hover {\n" +
                    "            transform: translateY(-5px);\n" +
                    "            box-shadow: 0 10px 30px rgba(0,0,0,0.2);\n" +
                    "        }\n" +
                    "\n" +
                    "        .product-img {\n" +
                    "            width: 100%;\n" +
                    "            height: 200px;\n" +
                    "            background: #f5f5f5;\n" +
                    "            display: flex;\n" +
                    "            align-items: center;\n" +
                    "            justify-content: center;\n" +
                    "            color: #999;\n" +
                    "            font-size: 14px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .product-info {\n" +
                    "            padding: 20px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .product-title {\n" +
                    "            font-size: 16px;\n" +
                    "            color: #333;\n" +
                    "            margin-bottom: 10px;\n" +
                    "            display: -webkit-box;\n" +
                    "            -webkit-line-clamp: 2;\n" +
                    "            -webkit-box-orient: vertical;\n" +
                    "            overflow: hidden;\n" +
                    "            height: 48px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .product-price {\n" +
                    "            font-size: 24px;\n" +
                    "            color: #ff4d4f;\n" +
                    "            font-weight: bold;\n" +
                    "            margin-bottom: 15px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .product-price span {\n" +
                    "            font-size: 14px;\n" +
                    "            color: #999;\n" +
                    "            font-weight: normal;\n" +
                    "        }\n" +
                    "\n" +
                    "        .platform-badge {\n" +
                    "            display: inline-block;\n" +
                    "            padding: 4px 12px;\n" +
                    "            border-radius: 4px;\n" +
                    "            font-size: 12px;\n" +
                    "            margin-bottom: 15px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .platform-taobao { background: #ff5000; color: white; }\n" +
                    "        .platform-jd { background: #e4393c; color: white; }\n" +
                    "        .platform-pdd { background: #e02e24; color: white; }\n" +
                    "        .platform-tmall { background: #ff6f00; color: white; }\n" +
                    "        .platform-1688 { background: #f00; color: white; }\n" +
                    "\n" +
                    "        .buy-btn {\n" +
                    "            display: block;\n" +
                    "            width: 100%;\n" +
                    "            padding: 12px;\n" +
                    "            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);\n" +
                    "            color: white;\n" +
                    "            border: none;\n" +
                    "            border-radius: 8px;\n" +
                    "            font-size: 16px;\n" +
                    "            cursor: pointer;\n" +
                    "            text-align: center;\n" +
                    "            text-decoration: none;\n" +
                    "            transition: opacity 0.2s;\n" +
                    "        }\n" +
                    "\n" +
                    "        .buy-btn:hover {\n" +
                    "            opacity: 0.9;\n" +
                    "        }\n" +
                    "\n" +
                    "        .no-results {\n" +
                    "            text-align: center;\n" +
                    "            color: white;\n" +
                    "            padding: 60px 20px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .no-results h2 {\n" +
                    "            margin-bottom: 10px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .loading {\n" +
                    "            text-align: center;\n" +
                    "            color: white;\n" +
                    "            padding: 60px 20px;\n" +
                    "            display: none;\n" +
                    "        }\n" +
                    "\n" +
                    "        .header {\n" +
                    "            text-align: center;\n" +
                    "            margin-bottom: 40px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .header h1 {\n" +
                    "            color: white;\n" +
                    "            font-size: 36px;\n" +
                    "            margin-bottom: 10px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .header p {\n" +
                    "            color: rgba(255,255,255,0.8);\n" +
                    "            font-size: 16px;\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <div class=\"container\">\n" +
                    "        <div class=\"header\">\n" +
                    "            <h1>全网比价</h1>\n" +
                    "            <p>搜索全网好物，一键比价购买</p>\n" +
                    "        </div>\n" +
                    "\n" +
                    "        <div class=\"search-box\">\n" +
                    "            <input type=\"text\" id=\"searchInput\" placeholder=\"请输入商品名称...\" onkeydown=\"if(event.key==='Enter')search()\">\n" +
                    "            <button onclick=\"search()\">搜索</button>\n" +
                    "        </div>\n" +
                    "\n" +
                    "        <div class=\"platforms\">\n" +
                    "            <span class=\"platform-tag\">淘宝</span>\n" +
                    "            <span class=\"platform-tag\">京东</span>\n" +
                    "            <span class=\"platform-tag\">拼多多</span>\n" +
                    "            <span class=\"platform-tag\">天猫</span>\n" +
                    "            <span class=\"platform-tag\">1688</span>\n" +
                    "        </div>\n" +
                    "\n" +
                    "        <div class=\"loading\" id=\"loading\">搜索中...</div>\n" +
                    "        <div class=\"no-results\" id=\"noResults\" style=\"display:none;\">\n" +
                    "            <h2>未找到相关商品</h2>\n" +
                    "            <p>请尝试其他关键词</p>\n" +
                    "        </div>\n" +
                    "        <div class=\"results\" id=\"results\"></div>\n" +
                    "    </div>\n" +
                    "\n" +
                    "    <script>\n" +
                    "        const platforms = [\n" +
                    "            { name: '淘宝', class: 'platform-taobao', color: '#ff5000', baseUrl: 'https://s.taobao.com/search?q=' },\n" +
                    "            { name: '京东', class: 'platform-jd', color: '#e4393c', baseUrl: 'https://search.jd.com/Search?keyword=' },\n" +
                    "            { name: '拼多多', class: 'platform-pdd', color: '#e02e24', baseUrl: 'https://mobile.yangkeduo.com/search_result.html?search_key=' },\n" +
                    "            { name: '天猫', class: 'platform-tmall', color: '#ff6f00', baseUrl: 'https://list.tmall.com/search_product.htm?q=' },\n" +
                    "            { name: '1688', class: 'platform-1688', color: '#f00', baseUrl: 'https://s.1688.com/youyuan/index.htm?tab=searchSearchType=suggest&keyword=' }\n" +
                    "        ];\n" +
                    "\n" +
                    "        function generateMockProducts(keyword) {\n" +
                    "            const products = [];\n" +
                    "            const basePrice = Math.random() * 500 + 50;\n" +
                    "\n" +
                    "            for (let i = 0; i < 10; i++) {\n" +
                    "                const platform = platforms[Math.floor(Math.random() * platforms.length)];\n" +
                    "                const priceVariation = (Math.random() - 0.5) * 100;\n" +
                    "                const price = Math.max(1, basePrice + priceVariation);\n" +
                    "\n" +
                    "                products.push({\n" +
                    "                    title: `${keyword} ${['爆款', '热销', '新品', '特价', '旗舰'][i % 5]} ${['官方正品', '包邮', '限时优惠', '顺丰发货'][i % 4]}`,\n" +
                    "                    price: price.toFixed(2),\n" +
                    "                    platform: platform,\n" +
                    "                    id: i\n" +
                    "                });\n" +
                    "            }\n" +
                    "\n" +
                    "            return products.sort((a, b) => parseFloat(a.price) - parseFloat(b.price));\n" +
                    "        }\n" +
                    "\n" +
                    "        function search() {\n" +
                    "            const keyword = document.getElementById('searchInput').value.trim();\n" +
                    "            if (!keyword) {\n" +
                    "                alert('请输入搜索关键词');\n" +
                    "                return;\n" +
                    "            }\n" +
                    "\n" +
                    "            const loading = document.getElementById('loading');\n" +
                    "            const results = document.getElementById('results');\n" +
                    "            const noResults = document.getElementById('noResults');\n" +
                    "\n" +
                    "            loading.style.display = 'block';\n" +
                    "            results.innerHTML = '';\n" +
                    "            noResults.style.display = 'none';\n" +
                    "\n" +
                    "            setTimeout(() => {\n" +
                    "                loading.style.display = 'none';\n" +
                    "                const products = generateMockProducts(keyword);\n" +
                    "\n" +
                    "                if (products.length === 0) {\n" +
                    "                    noResults.style.display = 'block';\n" +
                    "                    return;\n" +
                    "                }\n" +
                    "\n" +
                    "                products.forEach(product => {\n" +
                    "                    const card = document.createElement('div');\n" +
                    "                    card.className = 'product-card';\n" +
                    "                    card.innerHTML = `\n" +
                    "                        <div class=\"product-img\">商品图片</div>\n" +
                    "                        <div class=\"product-info\">\n" +
                    "                            <span class=\"platform-badge ${product.platform.class}\">${product.platform.name}</span>\n" +
                    "                            <h3 class=\"product-title\">${product.title}</h3>\n" +
                    "                            <div class=\"product-price\">¥${product.price} <span>起</span></div>\n" +
                    "                            <a href=\"${product.platform.baseUrl}${encodeURIComponent(keyword)}\" target=\"_blank\" class=\"buy-btn\">\n" +
                    "                                去${product.platform.name}购买\n" +
                    "                            </a>\n" +
                    "                        </div>\n" +
                    "                    `;\n" +
                    "                    results.appendChild(card);\n" +
                    "                });\n" +
                    "            }, 800);\n" +
                    "        }\n" +
                    "    </script>\n" +
                    "</body>\n" +
                    "</html>\n");
            ps.close();
            socket.close();

        } catch (IOException e) {
            System.out.println(Thread.currentThread().getName()+"客户端已断开连接");
        }


    }
}
