package controller;

import model.BaseModel;

/**
 * Created by admin on 28/12/2017.
 */

public interface CallBackListner {
    void handleSuccessData(BaseModel resModel);
    void handleZeroData(BaseModel reqModel);
    void handleErrorDataFromServer(BaseModel errorModel);
    void networkConnectionError();
    void handleInvalidData(BaseModel reqModel);
}
