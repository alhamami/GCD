# GCD
## Data structures used:
- We have opted to use Arrays for our program, since the number of 
variables is streamlined across the board. If a user wants to input three 
equations, then we store an integer array of size 3 for each 
type(coefficients, remainder, and modulo).

## Algorithm explanation:
- Input processing:
We first check if the Modulos are less than or equal to 1 and whether 
coefficients is equal to zero, this is solved by going through their 
respective arrays and checking. Then we need to process the inputs provided by the user. 
This is done by first, converting the negative coefficients into positive 
coefficients by using this property: if remainder is less than the 
modulo, then we simply do this equation to convert the remainder to 
accommodate the new coefficient: b(new) = moduolo – b
Example: -51=9 mod 10 becomes 51=1 mod 10,since 9<10. If 
remainder is higher than 10,then we simply subtract till we get the 
first number under the modulo.

### This process is provided by the following code:
> remainder = Tester.convertRemToPositive(remainder, mods);
remainder = Tester.convertRemainderToSmallest(remainder, mods);
if (c&&a) {
for (int i = 0; i < numbers; i++) {
if (coef[i] < 0) {
coef[i] *= -1;
remainder[i] = mods[i] - remainder[i];
}
 }

### Code for converting remainders to positive:
public int[] convertRemToPositive(int[]rem,int[]mods) {
for(int i=0;i<rem.length;i++) 
while(rem[i]<0) 
rem[i]+=mods[i];
return rem;
}
- O(n)

### Code for coverting remainder to be smaller than its respective 
modulos:
> public int[] convertRemainderToSmallest(int[] remainder,int[]mods) {
for(int i=0;i<remainder.length;i++) 
while(remainder[i]>mods[i]) 
remainder[i]-=mods[i];
return remainder;
}
- O(n)

### Checking for conditions:
- We check for whether the modulos are relatively prime, using this 
method:
> public boolean RelPrimeMods(int [] modSystem) {
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

- This basically checks for the GCD for each moduolo pair, and returns 
true if all of them have GCD of 1
- O(n2)
- Additionally we check if each equation’s Coefficient and Mod have GCD of 1
- The code has the same algorithm as the above code, except its O(n) since we only 
have to check for each equation.
### Using the CRT theorem:
- We first calculate M, which is the product of all the modulos, then we 
store the mi in an array of size n, the code is provided:
> for (int i = 0; i < numbers; i++)
      m *= mods[i];
for (int i = 0; i < numbers; i++)
     crt[i] = m / mods[i];
     
- Then, we need to calculate the inverse of each coefficient of x, 
normally we would use the Euclidean algorithm, but, since 
computers are much better at calculating by trial and error, we have 
opted to use a brute force approach.

- The method for finding inverse is:
> public int findModInverse(int a, int b) {
     int i=1;
     while(i<b) {
        if(a*i%b==1)
            return i;
        i++;
     }
     return 1;
}

- This uses the definition of inverse which is:There exist a’ such that 
a*a’=1 mod c, where a is coefficient of x and c is our modulo, we then change our 
remainders accordinglt(by multiplying it with the inverse)

- We do the same thing for mi as described in the project.

### We do the same thing for mi as described in the project
> for (int i = 0; i < numbers; i++) 
    x += remainder[i] * crt[i] * Tester.findModInverse(crt[i], mods[i]);
x = x % m;

- Given all of this, the overall O of this program is O(n2) 
because of the method relPrimeSystem being O(n2).

### Samples:
> 4
3  1  2
5  3  7
6  2  5
1  4  9
247

> 3
2  1  3
3  5  6
7  1  2
not solvable

> 2
2  1  -1
2  3   7
not solvable

## Conclusion:
- We have learned a ton of things from this project, primarily how a 
computer methods of calculating results is a stark contrast from 
humans,Computers are great at brute forcing while humans take a ton of 
time to calculate large iterations. Interestingly though, its easier for a 
human to calculate using the Euclidean algorithm, while writing it on a 
program is tricky.
