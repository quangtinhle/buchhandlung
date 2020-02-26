import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  title = 'thalia';
  firstName = '';
  isDisabled = false;

  clickHandler() {
    console.log('clicked...');
  }

  keydownHandler(event: KeyboardEvent) {
    if (event.key === 'Enter') {
      this.title = this.firstName;
    }
  }

  constructor() {
  }

  ngOnInit() {
  }

}
