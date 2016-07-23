
package team.weird.texteditor.parser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

import team.weird.texteditor.parser.Symbol.RightProduction;
import team.weird.texteditor.parser.ExtractProduction;
public class FirstSet{
	public HashMap<String, Symbol> symbolMap;
	public FirstSet(HashMap<String, Symbol> symbolMap){
		this.symbolMap = symbolMap;
	}
	public void createFirstSet(){
		Iterator<Entry<String, Symbol>> symIter = symbolMap.entrySet().iterator();
		while(symIter.hasNext()){
			Entry<String, Symbol> entry = symIter.next();
			Symbol temp = entry.getValue();
			Iterator<RightProduction> proIter = temp.rightList.iterator();
			while(proIter.hasNext()){
				LinkedList<String> list = proIter.next().getRightSymbolList();
				String firstSymStr =list.getFirst();
				if(!symbolMap.containsKey(firstSymStr)){
					temp.firstSet.add(firstSymStr);
				}
				else{
					if(temp.firstSet.isEmpty())
						disposeOfFirstSet(temp.firstSet, temp.getUnterminatingString());
					Iterator<String> proEpsilonIter = list.iterator();
					//String epsilonStr = new String(firstSymStr);
					String noEpsilonSymbol;
					while(proEpsilonIter.hasNext()){
						noEpsilonSymbol = proEpsilonIter.next();
						//System.out.println(noEpsilonSymbol);
						if(symbolMap.containsKey(noEpsilonSymbol) && symbolMap.get(noEpsilonSymbol).hasEpsilon);
						else if(symbolMap.containsKey(noEpsilonSymbol) && !symbolMap.get(noEpsilonSymbol).firstSet.isEmpty()){
							temp.firstSet.addAll(symbolMap.get(noEpsilonSymbol).firstSet);
							break;
						}
						else if(symbolMap.containsKey(noEpsilonSymbol) && symbolMap.get(noEpsilonSymbol).firstSet.isEmpty()){
							disposeOfFirstSet(temp.firstSet, noEpsilonSymbol);
							break;
						}
						else {
							temp.firstSet.add(noEpsilonSymbol);
							break;
						}
					}
				}
			}
		}
	}
	public void disposeOfFirstSet(Set<String> set, String untermination){
		if(!symbolMap.containsKey(untermination)){
			set.add(untermination);
			return;
		}
		Symbol temp = symbolMap.get(untermination);
		int index = 0;
		for(int i = 0; i < temp.rightList.size(); i++){
			RightProduction proTemp = temp.rightList.get(i);
			disposeOfFirstSet(temp.firstSet, proTemp.getFirstRightSymbol());	
			while(symbolMap.containsKey(proTemp.getFirstRightSymbol()) 
					&& index < proTemp.getRightSymbolList().size() 
					&& symbolMap.get(proTemp.getSymbolByIndex(index)).hasEpsilon){
				disposeOfFirstSet(temp.firstSet, proTemp.getSymbolByIndex(index));
				index++;
			}
				
		}
		set.addAll(temp.firstSet);
	}
	public void print(){
		System.out.println();
		System.out.println("-------------------------First Set-------------------------");
		System.out.println();
		Iterator<Entry<String, Symbol>> symIter = symbolMap.entrySet().iterator();
		while(symIter.hasNext()){
			Entry<String, Symbol> entry = symIter.next();
			Symbol temp = entry.getValue();
			Iterator<String> setIter = temp.firstSet.iterator();
			System.out.print(temp.getUnterminatingString()+" Size: "+temp.firstSet.size()+" $$ {");
			while(setIter.hasNext()){
				String print = setIter.next();
				System.out.print(print);
				if(setIter.hasNext())
					System.out.print(" ");
			}
			System.out.print("}");
			System.out.println();
		}
	}
}
