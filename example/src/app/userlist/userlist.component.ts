import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { UserDialogComponent } from '../user-dialog/user-dialog.component';



@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.css']
})

export class UserlistComponent  {
  displayedColumns = ['id', 'firstname', 'lastname', 'action'];
  data=[]

  constructor(private http:HttpClient,public dialog:MatDialog) { }

  ngOnInit(): void {
    this.http.get<any>('http://localhost:8080/user/findall').subscribe({
      next:data=>{
        this.data=data;
      },
      error:error=>{
        console.error('error:',error);
      }
      
    })
    
  }
  Add(){
    const dialogref =this.dialog.open(UserDialogComponent,{
      width:'20%',
      data:'add'
    });
    dialogref.afterClosed().subscribe(result=>{
      if (result){
        const body={
          firstname:result.value.firstname,
          lastname:result.value.lastname,
        }
        this.http.post<any>('http://localhost:8080/user/createuser',body).subscribe({
          next:data=>{
            this.ngOnInit();
          },
          error:error=>{
            console.error('error:',error);
          }
          
        })

      }
    })
  }
  edit(element:any){
    const dialogref =this.dialog.open(UserDialogComponent,{
      width:'20%',
      data:'edit'
    });
    dialogref.afterClosed().subscribe(result=>{
      if (result){
        const body={
          firstname:result.value.firstname,
          lastname:result.value.lastname,
        }
        this.http.put<any>('http://localhost:8080/user/updateuser/'+element.id,body).subscribe({
          next:data=>{
            this.ngOnInit();
          },
          error:error=>{
            console.error('error:',error);
          }
          
        })

      }
    })

  }
  delete(element:any){
    
    
    
    this.http.delete<any>('http://localhost:8080/user/deleteuser/'+element.id).subscribe({
      next:data=>{
        this.ngOnInit();
      },
      error:error=>{
        console.error('error:',error);
      }
      
    })

  }

}
