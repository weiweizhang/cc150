/**
* 思路：首先得到str长度，然后首尾交换字符，直到中间相遇。
* complexity: O(n) O(1)
*/
#include <stdio.h>
void reverse(char* str) {
    char* end = str;
    char tmp;
    while (*end) {
        end++;
    }
    end--;

    while (str < end) {
        tmp = *str;
        *str++ = *end;
        *end-- = tmp;
    }
}

int main() {
   char* s = "abc";

   printf("reversed str:%s\n",s);
   reverse(s);
   printf("reversed str:%s\n",s);
}