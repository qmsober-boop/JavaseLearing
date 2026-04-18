package 网络编程2.聊天软件;

import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentMap;

public class Consent {
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 8888;
    public static final Map<Socket,String> OnlineUsers =new ConcurrentMap<Socket, String>() {
        @Override
        public String putIfAbsent(Socket key, String value) {
            return "";
        }

        @Override
        public boolean remove(Object key, Object value) {
            return false;
        }

        @Override
        public boolean replace(Socket key, String oldValue, String newValue) {
            return false;
        }

        @Override
        public String replace(Socket key, String value) {
            return "";
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public String get(Object key) {
            return "";
        }

        @Override
        public String put(Socket key, String value) {
            return "";
        }

        @Override
        public String remove(Object key) {
            return "";
        }

        @Override
        public void putAll(Map<? extends Socket, ? extends String> m) {

        }

        @Override
        public void clear() {

        }

        @Override
        public Set<Socket> keySet() {
            return Set.of();
        }

        @Override
        public Collection<String> values() {
            return List.of();
        }

        @Override
        public Set<Entry<Socket, String>> entrySet() {
            return Set.of();
        }
    };
}
