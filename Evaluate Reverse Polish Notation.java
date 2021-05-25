class Solution {
    public int evalRPN(String[] tokens) {
        int operand1, operand2, result=0;
        Stack<Integer> st = new Stack<Integer>();
        List<String> operators = Arrays.asList("+","-","*","/");
        for(String s : tokens){
            if(operators.contains(s)){
                operand2 = st.pop();
                operand1 = st.pop();
                switch(s){
                    case "+": result = operand1+operand2;
                        break;
                    case "-": result = operand1-operand2;
                        break;
                    case "*": result = operand1*operand2;
                        break;
                    case "/": result = operand1/operand2;
                        break;
                }
                st.push(result);
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}