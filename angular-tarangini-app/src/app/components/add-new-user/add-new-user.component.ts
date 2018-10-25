import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user';
import { ActivatedRoute, Router } from '@angular/router';
import { UserServiceService } from '../../service/user-service.service';
import { Plans } from '../../model/plans';

@Component({
  selector: 'app-add-new-user',
  templateUrl: './add-new-user.component.html',
  styleUrls: ['./add-new-user.component.css']
})
export class AddNewUserComponent implements OnInit {

  user: User;
  planId: string;
  today = new Date();

  constructor(
    private activatedRoute: ActivatedRoute,
    private userService: UserServiceService,
    private router: Router
  ) { }

  ngOnInit() {
    this.user = new User();


    this.activatedRoute.params.subscribe(
      (params) => {
        this.planId = params['id'];
      }
    );
  }

  save() {
    this.userService.addUser(this.user).subscribe(
      (data) => {
        this.user = data;
        alert("Successfully Added");
        alert("Your order no is: " + this.user.orderNumber + " Our official will get in touch with you for installation on " + this.date() + " at " + this.user.address);
        this.router.navigateByUrl("/listPlans");
      },
      (error) => {
        alert("Already registered. Please contact customer care executives")
      }

    );

  }

  date(): Date {
    var someDate = new Date();
    var numberOfDaysToAdd = 4;
    someDate.setDate(someDate.getDate() + numberOfDaysToAdd);
    return someDate;
  }


}
