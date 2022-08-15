
public class GCD {
	public boolean RelPrimeMods(int [] modSystem) {
		for(int i=0;i<modSystem.length-1;i++) {
			for(int j=i+1;j<modSystem.length;j++) {
				for(int k=2;k<=modSystem[i] && k<=modSystem[j];k++) {
					if(modSystem[i]%k==0 && modSystem[j]%k==0)
						return false;
				}
			}
		}
		return true;
	}
	public boolean relPrimeSystem(int [] cof, int[] mods,int n) {
		for (int i=0;i<n;i++) {
			for(int k=2;k<=cof[i] && k<=mods[i];k++) {
				if(mods[i]%k==0 && cof[i]%k==0)
					return false;
			}
		}
		return true;
	}
	public int[] convertRemToPositive(int[]rem,int[]mods) {
		for(int i=0;i<rem.length;i++) 
			while(rem[i]<0) 
				rem[i]+=mods[i];
			
			
		
		return rem;
	}
	public int[] convertRemainderToSmallest(int[] remainder,int[]mods) {
		for(int i=0;i<remainder.length;i++) 
			while(remainder[i]>mods[i]) 
				remainder[i]-=mods[i];
			return remainder;
		
	}
	public int findModInverse(int a, int b) {
		int i=1;
		while(i<b) {
			if(a*i%b==1)
				return i;
			i++;
		}
		return 1;
	}
}
