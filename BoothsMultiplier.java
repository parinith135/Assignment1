/*12. Implement a JAVA program to implement a Booth multiplier. */
class BoothsMultiplier{
    public int multiply(int n1, int n2)
    {
        int[] m = binary(n1);
        int[] m1 = binary(-n1);
        int[] r = binary(n2);        
        int[] A = new int[9];
        int[] S = new int[9];
        int[] P = new int[9];        
        for (int i = 0; i < 4; i++)
        {
            A[i] = m[i];
            S[i] = m1[i];
            P[i + 4] = r[i];
        }
        
        for (int i = 0; i < 4; i++)
        {
            if (P[7] == 0 && P[8] == 0);
          
            else if (P[7] == 1 && P[8] == 0)
                add(P, S);                            
            else if (P[7] == 0 && P[8] == 1)
                add(P, A);            
            else if (P[7] == 1 && P[8] == 1);

            rightShift(P);
        }
        return getDecimal(P);
    }
    
    public int getDecimal(int[] B)
    {
        int p = 0;
        int t = 1;
        for (int i = 7; i >= 0; i--, t *= 2)
            p += (B[i] * t);
        if (p > 64)
            p = -(256 - p);
        return p;        
    }
    
    public void rightShift(int[] A)
    {        
        for (int i = 8; i >= 1; i--)
            A[i] = A[i - 1];        
    }
    
    public void add(int[] A, int[] B)
    {
        int carry = 0;
        for (int i = 8; i >= 0; i--)
        {
            int temp = A[i] + B[i] + carry;
            A[i] = temp % 2;
            carry = temp / 2;
        }        
    }

    public int[] binary(int n)
    {
        int[] bin = new int[4];
        int ctr = 3;
        int num = n;
        if (n < 0)
            num = 16 + n;
        while (num != 0)
        {
            bin[ctr--] = num % 2;
            num /= 2;
        }
        return bin;
    }

    public static void main (String[] args) 
    {
        BoothsMultiplier b = new BoothsMultiplier();
        int n1 = 5;
        int n2 = 4;
        int result = b.multiply(n1, n2);
        System.out.println("Result : "+ n1 +" * "+ n2 +" = "+ result);                    
    }
}