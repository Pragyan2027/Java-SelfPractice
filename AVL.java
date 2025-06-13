
public class AVL {
    public class node{
        private int value;
        private int height;
        private node left;
        private node right;

        public node(int value){
            this.value = value;
        }
        public int getvalue(){
            return value;
        }
    }
    private node root;
    public AVL(){

    }
    public int height(node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty(){
        return root==null;
    }

    public void insert(int value) {
        root = insert(value, root);
      }
    
      private node insert(int value, node node) {
        if (node == null) {
          node = new node(value);
          return node;
        }
    
        if (value < node.value) {
          node.left = insert(value, node.left);
        }
    
        if (value > node.value) {
          node.right = insert(value, node.right);
        }
    
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
      }
      private node rotate(node node) {
        if (height(node.left) - height(node.right) > 1) {
          // left heavy
          if(height(node.left.left) - height(node.left.right) > 0) {
            // left left case
            return rightRotate(node);
          }
          if(height(node.left.left) - height(node.left.right) < 0) {
            // left right case
            node.left = leftRotate(node.left);
            return rightRotate(node);
          }
        }
        public node rightRotate(node p) {
            node c = p.left;
            node t = c.right;
        
            c.right = p;
            p.left = t;
            
            p.height = Math.max(height(p.left), height(p.right) + 1);
            c.height = Math.max(height(c.left), height(c.right) + 1);
        
            return c;
          }
        
          public node leftRotate(node c) {
            node p = c.right;
            node t = p.left;
        
            p.left = c;
            c.right = t;
            
            p.height = Math.max(height(p.left), height(p.right) + 1);
            c.height = Math.max(height(c.left), height(c.right) + 1);
        
            return p;
          }
      public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
          this.insert(nums[i]);
        }
      }
    
      public void populatedSorted(int[] nums) {
        populatedSorted(nums, 0, nums.length);
      }
    
      private void populatedSorted(int[] nums, int start, int end) {
        if (start >= end) {
          return;
        }
    
        int mid = (start + end) / 2;
    
        this.insert(nums[mid]);
        populatedSorted(nums, start, mid);
        populatedSorted(nums, mid + 1, end);
      }
    
      public boolean balanced() {
        return balanced(root);
      }
    
      private boolean balanced(node node) {
        if (node == null) {
          return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
      }
    
    public void display(){
        display(root,"Root node : ");
    }
    private void display(node node,String details){
        if(node==null){
            return;
        }
        System.out.println(details + node.getvalue());
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }
}
