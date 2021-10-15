package minji.sharinglibraryserver.common.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ResponseService{

    public<T> SingleResponse<T> getSingleResponse(T data){
        SingleResponse<T> singleResponse=new SingleResponse();
        singleResponse.data=data;

        log.debug("data= "+ singleResponse.data);
        setSuccessResponse(singleResponse);
        log.debug("response= "+singleResponse.code+" "+ singleResponse.success);

        return singleResponse;
    }

    public<T> ListResponse<T> getListResponse(List<T> dataList){
        ListResponse<T> listResponse = new ListResponse();
        listResponse.dataList=dataList;
        setSuccessResponse(listResponse);

        return listResponse;
    }

    void setSuccessResponse(CommonResponse response){
        response.code=0;
        response.success=true;
        response.message="SUCCESS";
    }
}
