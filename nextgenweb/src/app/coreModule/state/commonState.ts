import {createSelector} from "@ngxs/store";

export class CommonState {
    static selectAll<T>() {
        return createSelector([this], (state: T) =>{
            return state;
        });
    }
}