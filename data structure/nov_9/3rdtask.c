#include<stdio.h>
struct student{
  int roll;
  char name[100];
  float cg;
}ar_stdnt[48];

void filewrite(struct student *ar){
  FILE *fp= fopen("output.txt","w");
  for(int i = 0 ; i<48; i++){
     fprintf(fp,"%d\n%s\n%f\n",ar->roll,ar->name,ar->cg);
     ar++;
  } 
  fclose(fp);
}

void filedelete(struct student *ar,int idx){
  FILE *fp= fopen("output.txt","w");
  for(int i = 0 ; i<48; i++){
    if(i==idx) continue;
     fprintf(fp,"%d\n%s\n%f\n",(ar+i)->roll,(ar+i)->name,(ar+i)->cg);
  } 
  fclose(fp);
  freopen("output.txt","r",stdin);
  for(int j  = 0; j<48;j++){
           scanf("%d",&ar_stdnt[j].roll);
           scanf(" %[^\n]",ar_stdnt[j].name);
           scanf("%f",&ar_stdnt[j].cg);
  }
  freopen("/dev/tty","r",stdin);
}

int search(int roll,struct student *arr ){

for(int i = 0 ; i<48; i++){
    if(roll == arr[i].roll)
      return i;
  }
  return 12345;
}

int main(){
    freopen("output.txt","r",stdin);
for(int j  = 0; j<48;j++){
           scanf("%d",&ar_stdnt[j].roll);
           scanf(" %[^\n]",ar_stdnt[j].name);
           scanf("%f",&ar_stdnt[j].cg);
  }
  freopen("/dev/tty","r",stdin);

struct student *ar = ar_stdnt;
  while(1){
     printf("to search press 1,to delete press 2,to append press 3,to edit press 4, to stop press 5\n");
     int check;
     scanf(" %d",&check);
     if(check == 5) break;

     switch(check){
      case 1:
           printf("enter the roll ");
           int r = 100000;
           scanf("%d",&r);
           int idx = search(r,ar);
           if(idx == 12345){
           printf("\n valo kore input den miya\n");
            break;}
           printf("roll %d name %s cg %f\n\n",ar[idx].roll,ar[idx].name,ar[idx].cg);
           break;
      case 2:
           printf("enter the roll to delete");
           r = 1000000;
           scanf("%d",&r);
           idx = search(r,ar);
           filedelete(ar,idx);
           break;
      case 3:
           idx = search(0,ar);
           struct student a;
           scanf("%d",&(ar+idx)->roll);
           scanf(" %[^\n]",(ar+idx)->name);
           scanf("%f",&(ar+idx)->cg);
           filewrite(ar);
        freopen("output.txt","r",stdin);
         for(int j  = 0; j<48;j++){
           scanf("%d",&ar_stdnt[j].roll);
           scanf(" %[^\n]",ar_stdnt[j].name);
           scanf("%f",&ar_stdnt[j].cg);
         }
         freopen("/dev/tty","r",stdin);
           break;
      case 4:
           printf("enter the roll to edit");
           scanf("%d",&r);
           idx = search(r,ar);
           scanf("%d",&(ar+idx)->roll);
           scanf(" %[^\n]",(ar+idx)->name);
           scanf("%f",&(ar+idx)->cg);
           break;
      default:
           filewrite(ar);
           break;
    }
  }
  return 0;
}
