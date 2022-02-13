package minji.sharinglibraryserver.common.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ResponseService{

    //단일 데이터 응답
    public<T> SingleResponse<T> getSingleResponse(T data){
        SingleResponse<T> singleResponse=new SingleResponse();
        singleResponse.data=data;
        setSuccessResponse(singleResponse);
        return singleResponse;
    }

    //리스트 데이터 응답
    public<T> ListResponse<T> getListResponse(List<T> dataList){
        ListResponse<T> listResponse = new ListResponse();
        listResponse.dataList=dataList;
        setSuccessResponse(listResponse);
        return listResponse;
    }

    //에러 응답
    public CommonResponse getErrorResponse(int code, String message){
        CommonResponse response= new CommonResponse();
        response.success=false;
        response.code=code;
        response.message=message;
        return response;
    }

    //성공결과 응답
    public CommonResponse getSuccessResponse(){
        CommonResponse response=new CommonResponse();
        setSuccessResponse(response);
        return response;
    }

   private void setSuccessResponse(CommonResponse response){
        response.code=0;
        response.success=true;
        response.message="SUCCESS";
    }
}
