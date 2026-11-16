#include<stdio.h>
#include <stdlib.h>
#include<string.h>
typedef struct student{
  int roll;
  char name[100];
  float cg;
  struct student *link;
}student;

student *createnode(int roll, char name[],float cg);
void append(student **adam,int roll, char name[],float cg);
void display(student *adam);
void takeInput(student **adam);
void search(student *adam,int roll);
void writeinfile(student *adam);
void menu(student **adam);


int main(){
student *adam = NULL;
menu(&adam);
}

void takeInput(student **adam){
int roll;
char name[100];
float cg;
scanf("%d",&roll);
scanf(" %[^\n]",name);
scanf(" %f",&cg);
append(adam,roll,name,cg);
}

student *createnode(int roll, char name[],float cg){
  student *newnode = (student*)malloc(sizeof(student));
  newnode->roll = roll;
  strcpy(newnode->name,name);
  newnode->cg = cg;
  newnode->link = NULL;
  return newnode;
}

void append(student **adam,int roll, char name[],float cg){
student *newnode = createnode(roll,name,cg);
  if(newnode==NULL) return;
  if(*adam == NULL){
  *adam = newnode;
    return;
  }
student *temp = *adam;
while(temp->link!=NULL){
  temp = temp->link;
  }
temp->link = newnode;
}

void display(student *adam){
  student *current = adam;
  while(current!= NULL){
  printf("%d %s %f\n",current->roll,current->name,current->cg);
  current = current->link;
  }
}

void search(student *adam,int roll){
 student *current = adam;
while(current != NULL){
  if(current->roll == roll){
    printf("%d %s %f\n",current->roll,current->name,current->cg);
    return;
  }
    current = current->link;
}
printf("the roll doesnt exist");
}

void writeinfile(student *adam){
  FILE *fp = fopen("output.txt","w");
  student *current = adam;
  while(current != NULL){
    fprintf(fp,"%d %s %f\n",current->roll,current->name,current->cg);
    current = current->link;
  }
fclose(fp);
}
void deleteAnode(student **adam, int roll){
  student **current = adam;

 while(*current != NULL && (*current)->roll != roll){
      current = &(*current)->link;
      break;
  }


student *delete = *current;
*current = delete->link;

}

void menu(student **adam){
    int check;
while(1){
  printf("\n1 to add a new student");
  printf("\n2 to display\n3 to deleteAnode\n4 to quit ");

  scanf(" %d",&check);
  if(check == 1){
   takeInput(adam);
   writeinfile(*adam);
   printf("\nstudent added");}

  else if(check == 2){
  if(adam == NULL) printf("kothao keu nei");
  printf("\n=======THE LIST OF STUDENT========\n");
  display(*adam);
  }
  else if(check == 3){
    printf("\nenter the roll to dlete ");
    int roll;
    scanf(" %d",&roll);
    deleteAnode(adam,roll);
    writeinfile(*adam);
    printf("\nnewly updated list is...\n");
    display(*adam);
  }
  else if(check == 4) break;
}
}
