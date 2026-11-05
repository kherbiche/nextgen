import {CommonState} from "../../coreModule/state/commonState";
import {Injectable} from "@angular/core";
import {Action, State, StateContext} from "@ngxs/store";
import {TwoMainService} from "../services/two.main.service";
import {TwoMainData} from "../models/twoMainData";
import {cloneDeep, merge} from "lodash";

export class Init {
    static readonly type = '[Two] Init';

    constructor(public prsId: string, public codeInter: string) {}
}

export class UpdatePreambule {
    static readonly type = '[Two] UpdatePreambule';
    constructor(public formValue) {}
}

export class UpdateInfoperso {
    static readonly type = '[Two] UpdateInfoperso';
    constructor(public formValue) {}
}

@State<TwoMainData>({
    name: 'TwoMainState',
    defaults: null
})
@Injectable()
export class TwoMainState extends CommonState {

    constructor(private twoMainService: TwoMainService) {
        super();
    }

    @Action(Init)
    init(ctx: StateContext<TwoMainData>, action: Init) {
        this.twoMainService.init(action.prsId, action.codeInter).subscribe(resul => {
            //const data = resul['twoForm'];
            const data = resul;
            if (data) {
                ctx.setState(<TwoMainData>data);
            }
        });
    }

    @Action(UpdatePreambule)
    updatePreambule(ctx: StateContext<TwoMainData>, action: UpdatePreambule) {
        const state = cloneDeep(ctx.getState());
        merge(state.preambule, action.formValue);
        ctx.setState(state);
    }

    @Action(UpdateInfoperso)
    updateInfoperso(ctx: StateContext<TwoMainData>, action: UpdateInfoperso) {
        const state = cloneDeep(ctx.getState());
        merge(state.infoperso, action.formValue);
        ctx.setState(state);
    }
}