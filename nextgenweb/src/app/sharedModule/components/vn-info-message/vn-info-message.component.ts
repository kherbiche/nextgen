import {Component, Input} from "@angular/core";

enum MessageTypeEnum {
    SUCCES = '',
    WARNING = 'amber',
    IMPORTANT = 'important',
    NEUTRAL = 'neutral'
}
@Component({
    selector: 'vn-info-message',
    templateUrl: './vn-info-message.component.html'
})
export class VnInfoMessageComponent {

    @Input() type: string = MessageTypeEnum.SUCCES;
    @Input() infoMsgCustomClass: string;

    constructor() {}

    messageClass(key) {
        return MessageTypeEnum[key];
    }
}