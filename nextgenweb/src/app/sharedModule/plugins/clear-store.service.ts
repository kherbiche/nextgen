import {getActionTypeFromInstance} from "@ngxs/store";

export class ClearStore {
    static readonly type = "[App] Clear store";
}

export function clearStorePlugin(state, action, next){
    // Use the get action type helper to determine the type
    if (getActionTypeFromInstance(action) === ClearStore.type) {
        // if we are a logout type, lets erase all the state
        state = {};
    }

    //return the next function with the empty state
    return next(state, action);
}