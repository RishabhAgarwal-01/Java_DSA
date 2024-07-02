public class CompressString {
    public static void compress(String str) {
        StringBuilder st = new StringBuilder(str);
        StringBuilder compressString = new StringBuilder();
        int count;

        for (int i = 0; i < str.length(); i++) {
            char ch = st.charAt(i);
            count = 1;

            while (i + 1 < str.length() && ch == st.charAt(i + 1)) {
                count++;
                i++;
            }

            compressString.append(ch);
            compressString.append(count);
        }

        System.out.println(compressString.toString());
    }

    public static void main(String[] args) {
        String str = "aaabbccaadddd";
        compress(str);
    }
}
