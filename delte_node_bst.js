 @param {TreeNode} root
 * @param {number} key
 * @return {TreeNode}
 */
var deleteNode = function(root, key) {
    if(root === null){
        return null;
    } 
    if(key<root.val){
        root.left=deleteNode(root.left,key);
    } 
    else if(key>root.val){
        root.right=deleteNode(root.right,key);
    } 
    else{
        if(root.left===null){
            return root.right;
        } 
        else if(root.right===null){
            return root.left;
        }
        let succ=helper(root.right);
        root.val=succ.val;
        root.right=deleteNode(root.right,succ.val);
    }
    return root;
};
function helper(root){
    while(root.left!==null) {
        root=root.left;
    }
    return root;
};
