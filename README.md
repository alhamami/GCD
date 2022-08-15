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


