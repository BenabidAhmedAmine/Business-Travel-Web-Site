import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
const API_URL = 'http://localhost:8080/SpringMVC/user/';
const API='http://localhost:8080/SpringMVC/api/auth/';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) { }
  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'all', { responseType: 'text' });
  }
  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'EMPL', { responseType: 'text' });
  }
  getModeratorBoard(): Observable<any> {
    return this.http.get(API_URL + 'COMPA', { responseType: 'text' });
  }
  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + 'ADMIN', { responseType: 'text' });
  }

  verifyAccount(confirmationCode:string,userId:string): Observable<any> {
    return this.http.put(API_URL + 'verifaccount/'+confirmationCode+'/'+userId, { responseType: 'text' });
  }
  Changepassword(Password:string,Username:string,newmdp:string): Observable<any> {
    return this.http.put(API + 'changePassword/'+Password+'/'+newmdp+'/'+Username, { responseType: 'text' });
  }
  verifcodepassword(code:string,userid:string): Observable<any> {
    return this.http.put(API + 'userCode/'+code+'/'+userid, { responseType: 'text' });
  }
  RegisterFromCsv(): Observable<any> {
    return this.http.get(API_URL + 'RegisterFromCsv');
  }

}
