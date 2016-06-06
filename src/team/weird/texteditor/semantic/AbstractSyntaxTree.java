package team.weird.texteditor.semantic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

import team.weird.texteditor.lexer.Token;

public class AbstractSyntaxTree {
	private SyntaxTreeNode root = null;
//	private HashSet<String> terminatingSet;
//	private Stack<HashMap<String, Token>> varSymbolTable = 
//			new Stack<HashMap<String, Token>>();
//	private HashSet<String> typeSet = new HashSet<String>();
	private String type;
	private static int depth = 1;

	public AbstractSyntaxTree(SyntaxTreeNode entrance,
			HashSet<String> terminatingSet) {
		this.root = entrance;
//		this.terminatingSet = terminatingSet;
		displayTreeNode(root);

	}
	
	public void displayTreeNode(Token root){
//		System.out.println(((SyntaxTreeNode)root).getSymbol());
//		System.out.println(((SyntaxTreeNode) root).getChildList().size());
		if(root.getClass().getSimpleName().equals("SyntaxLeafNode"))
			return;
		Iterator<Token> displayIter = ((SyntaxTreeNode) root).getChildList().iterator();
		while(displayIter.hasNext()){
			Token temp = displayIter.next();	
			//System.out.println(((SyntaxTreeNode) temp).getChildList().size());
			displayTreeNode(temp);
		}
		
		
		
	}
//	public void displayTree(SyntaxTreeNode root) {
//		System.out.println(root.toString() + " <depth>: " + depth);
//		depth++;
//		Iterator<SyntaxTreeNode> displayIter = root.getChildList().iterator();
//		System.out.print("<|");
//		while (displayIter.hasNext()) {
//			System.out.print(displayIter.next().getSymbol() + " ");
//		}
//		System.out.print("|>");
//		System.out.println();
//		Iterator<SyntaxTreeNode> iter = root.getChildList().iterator();
//		while (iter.hasNext()) {
//			displayTree(iter.next());
//		}
//		depth--;
//
//	}

//	public void postOrderTraverse(SyntaxTreeNode root) {
//		if (root.getChildList().size() == 0) {
//			if (terminatingSet.contains(root.getSymbol()))
//				visitNode(root);
//			else
//				;
//			return;
//		}
//		int index = root.getChildList().size() - 1;
//		ListIterator<SyntaxTreeNode> iter = root.getChildList().listIterator(
//				index);
//		while (iter.hasPrevious())
//			postOrderTraverse(iter.previous());
//	}
//
//	public void visitNode(SyntaxTreeNode node){
//		if(typeSet.contains(node.getSymbol()))
//			type = node.getSymbol();
//		else if(node.getSymbol().equals("ID")){
//			
//		}

}
