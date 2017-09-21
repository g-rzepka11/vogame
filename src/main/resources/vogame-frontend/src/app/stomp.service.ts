import {Injectable} from '@angular/core';
import {Subject} from 'rxjs/Subject';
import {Observable} from 'rxjs/Observable';

import 'stompjs';

declare let Stomp:any;

@Injectable()
export class StompService {

    private _stompClient;
    private _stompSubject : Subject<any> = new Subject<any>();
    private _stompSubjectWord : Subject<any> = new Subject<any>();

    public connect(_webSocketUrl: string) : void {
        let self = this;
        let webSocket = new WebSocket(_webSocketUrl);
        this._stompClient = Stomp.over(webSocket);
        this._stompClient.connect({}, function (frame) {
            self._stompClient.subscribe('/topic/counter', function (stompResponse) {
                self._stompSubject.next(JSON.parse(stompResponse.body));
            });
            self._stompClient.subscribe('/topic/word', function (stompResponse) {
                self._stompSubjectWord.next(JSON.parse(stompResponse.body));
            });
        });
    }

    public send(_payload: string) {
        this._stompClient.send("/app/check", {}, JSON.stringify({'word': _payload}));
    }

    public getObservable() : Observable<any> {
        return this._stompSubject.asObservable();
    }

    public getObservableWord() : Observable<any> {
        return this._stompSubjectWord.asObservable();
    }
}
