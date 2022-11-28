import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-user-dialog',
  templateUrl: './user-dialog.component.html',
  styleUrls: ['./user-dialog.component.css']
})
export class UserDialogComponent implements OnInit {
  userFormGroup!: FormGroup;
  constructor(public dialog:MatDialogRef<UserDialogComponent>,@Inject(MAT_DIALOG_DATA) public data:string) { }

  ngOnInit(): void {
    this.userFormGroup= new FormGroup({
      firstname: new FormControl('',[Validators.required]),
      lastname: new FormControl('',[Validators.required])
    })
  }
  onNoClick(){
    this.dialog.close();
  }

}
