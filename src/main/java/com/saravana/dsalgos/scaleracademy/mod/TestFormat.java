package com.saravana.dsalgos.scaleracademy.mod;

public class TestFormat {

    public int solve(int[] A, int B) {
        long[] remainArr= new long[B];
        int MOD=(1000*1000*1000)+7;
        for(int i=0;i<A.length;i++)
        {
            int index=A[i]%B;
            remainArr[index]=remainArr[index]+1;
        }
        long ans=0;
        ans= ans+((remainArr[0]*(remainArr[0]-1))/2);
        ans=ans;
        int i=1;
        int j=B-1;
        while(i<j)
        {
            ans=ans+remainArr[i]*remainArr[j];
            ans=ans;
            i++;
            j--;
        }
        if(B%2==0)
        {
            ans=ans+(remainArr[B/2]*(remainArr[B/2]-1)/2);
        }
        return (int)(ans%MOD);
    }
}
