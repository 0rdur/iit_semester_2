#include<stdio.h>
struct student{
  int roll;
  char name[100];
  float cg;
}ar_stdnt[48];


int main(){
struct student *ar = ar_stdnt;
freopen("input.txt","r",stdin);
for(int i = 0 ; i<5; i++){
     scanf("%d",&ar->roll);   
     scanf(" %[^\n]",ar->name);
     scanf("%f",&ar->cg);
     ar++;
  }

ar = ar_stdnt;
for(int i = 0 ; i<5; i++){

     printf("\n \nroll %d",ar->roll);
     printf("\nname %s",ar->name );
     printf("\nenter cg %f",ar->cg);
     ar++;
  } 
printf("\n");

  return 0;
}
