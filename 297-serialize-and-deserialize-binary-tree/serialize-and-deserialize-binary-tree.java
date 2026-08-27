public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");

        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        int[] index = {0};

        return helper(values, index);
    }

    private TreeNode helper(String[] values, int[] index) {

        // Get current value
        String value = values[index[0]];

        // Move to next value
        index[0]++;

        // If null, there is no node
        if (value.equals("null")) {
            return null;
        }

        // Create node using CURRENT value
        TreeNode root = new TreeNode(Integer.parseInt(value));

        // First recursive call = LEFT
        root.left = helper(values, index);

        // Second recursive call = RIGHT
        root.right = helper(values, index);

        return root;
    }
}
