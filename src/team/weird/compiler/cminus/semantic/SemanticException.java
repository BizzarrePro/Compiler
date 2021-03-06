package team.weird.compiler.cminus.semantic;

import team.weird.compiler.cminus.semantic.Type;


public class SemanticException extends Exception {
	/**
	 * Report Syntactic Error
	 */
	private static final long serialVersionUID = 1L;
	private String message = null;

	public SemanticException() {

	}

	public SemanticException(String args, int line, int type) {
		switch (type) {
			case 0:
				this.message = "Variable '"+ args +"': '"+ args + "' was not declared in the scope at line " + line;
				break;
			case 1:
				this.message = "Parser: An error appears in syntax"+ "near '" + args + "' at line " + line;
				break;
			case 2:
				this.message ="Variable '"+ args +"': Conflicting declaration '" + args + "' at line " + line;
				break;
			case 3:
				this.message = "Variable '" + args + "': was not declared in the scope at line " + line;
				break;
			case 4:
				this.message = "Variable '"+ args +"': Variable couldn't be declared 'void'"
						+ "syntax to use near '" + args + "' at line " + line;
				break;
			case 5:
				this.message = "Array '"+ args +"': Size of array '" + args + "' has non-integral type 'double' at line " + line;
				break;
			case 6:
				this.message = "Method '"+ args +"': 'void' methods can not return a value at line " + line ;
				break;
			case 7:
				this.message = "Method '"+ args +"': return value is not match with method declaration at line " + line ;
				break;
			case 8:
				this.message = "Method '" + args + "': was not declared in the scope at line " + line;
				break;
			case 9:
				this.message = "Array '" + args + "': Invalid types for array subscript at line " + line;
				break;
			case 10:
				this.message = "Variable '" + args + "': Incompatible types in assignment at line " + line;
				break;
			case 11:
				this.message = "Method '" + args + "': Method parameters is not applicable for the arguments at line " + line;
				break;
			case 12:
				this.message = "Expression '" + args + "': Selection statement expression is not match at line " + line;
				break;
			case 13:
				this.message = "Expression '" + args + "': Iterator statement expression is not match at line " + line;
				break;
			case 14:
				this.message ="Method '"+ args +"': Conflicting declaration '" + args + "' at line " + line;
				break;
			case 15:
				this.message ="Expression '"+ args +"': Iterator statement condition '" + args + "' error at line " + line;
				break;
			case 16:
				this.message = "Array '" + args + "': Array index out of bounds at line " + line;
				break;
			case 17:
				this.message = "Method '" + args + "': Method return value couldn't be assigned at line " + line;
				break;
		}
	}
	
	public SemanticException(Type type0, Type type1, int line) {
		this.message = "Type '" + type0.toString() +"' and type '" + type1.toString() + "' mismatch at line " + line;
	}

	public String toString() {
		return message;
	}

	public String getMessage() {
		return message;
	}

}