class Solution {
    public String smallestSubsequence(String s) {
         int[] freq = new int[26];
        boolean[] visited = new boolean[26];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            // One occurrence is being processed
            freq[ch - 'a']--;

            // Already present in answer
            if (visited[ch - 'a']) {
                continue;
            }

            // Remove larger characters if they appear later
            while (!st.isEmpty()
                    && st.peek() > ch
                    && freq[st.peek() - 'a'] > 0) {

                visited[st.pop() - 'a'] = false;
            }

            st.push(ch);
            visited[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}