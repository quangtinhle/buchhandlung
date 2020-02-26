import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Buch} from '../models/Buch';

@Injectable({
  providedIn: 'root'
})
export class BuchService {
  url = 'http://localhost:8080/buchs';

  constructor(private httpClient: HttpClient) {
  }

  //  GET All Buchs
  getBuchs(): Observable<Buch[]> {
    return this.httpClient.get<Buch[]>(this.url);
  }
}
