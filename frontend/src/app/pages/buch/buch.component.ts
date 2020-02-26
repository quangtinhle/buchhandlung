import {Component, OnInit} from '@angular/core';
import {BuchService} from '../../services/buch.service';
import {Buch} from '../../models/Buch';

@Component({
  selector: 'app-buch',
  templateUrl: './buch.component.html',
  styleUrls: ['./buch.component.scss']
})
export class BuchComponent implements OnInit {
  buchs: Buch[];

  constructor(private buchService: BuchService) {
  }

  ngOnInit() {
    this.buchService.getBuchs().subscribe(buchs => {
      this.buchs = buchs;
    });
  }

}
