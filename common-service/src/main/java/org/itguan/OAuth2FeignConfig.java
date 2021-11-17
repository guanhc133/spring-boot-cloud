package org.itguan;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Slf4j
public class OAuth2FeignConfig implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(requestAttributes==null){
            String header = "bearer " + "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhbGwiXSwiZXhwIjozNzg0NjE4NzA2LCJqdGkiOiJiZmIzY2FjMy02ZTgyLTQ5OTctYjdkOS00NTU2NTYyMzJiZDUiLCJjbGllbnRfaWQiOiJpbnNpZGUtYXBwIn0.gXkcF_RAoCh2qV6w9dIz1sXY1XQFqImCY4qH2nnfmVHDVKu8riRTPHSsxf1PkcUoAc8DPOUQP3_RWrtRpJgPhqV5zm3utmj4DVM-t_fHfW2xvur_Pv5PYPY6jcsgvLXNtNJ0S692P24sDvJ_wn79teHIfVFPEsi3Tja72tEpRK4VhQvYbcUBEN3ZxNq4NgX5Vnt0A6ZeK10J04oIc58uFPEenoOK0wzALik9UX2ESuZn8MbozqFRILil22sPh1hpC9KnJmNLwKatLMXl7cB_NTOeCvzFYQeV8jUwG2oCI_RmD_WVwu7dni45VmzWsdxqiD4yNhm43aaHflLzAN5iMQ";
            requestTemplate.header(HttpHeaders.AUTHORIZATION,header);
        } else {
            String token = ((ServletRequestAttributes) requestAttributes).getRequest().getParameter(HttpHeaders.AUTHORIZATION);
            if(StringUtils.hasLength(token)){
                requestTemplate.header(HttpHeaders.AUTHORIZATION,token);
            } else {
                String header = "bearer " + "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhbGwiXSwiZXhwIjozNzg0NjE4NzA2LCJqdGkiOiJiZmIzY2FjMy02ZTgyLTQ5OTctYjdkOS00NTU2NTYyMzJiZDUiLCJjbGllbnRfaWQiOiJpbnNpZGUtYXBwIn0.gXkcF_RAoCh2qV6w9dIz1sXY1XQFqImCY4qH2nnfmVHDVKu8riRTPHSsxf1PkcUoAc8DPOUQP3_RWrtRpJgPhqV5zm3utmj4DVM-t_fHfW2xvur_Pv5PYPY6jcsgvLXNtNJ0S692P24sDvJ_wn79teHIfVFPEsi3Tja72tEpRK4VhQvYbcUBEN3ZxNq4NgX5Vnt0A6ZeK10J04oIc58uFPEenoOK0wzALik9UX2ESuZn8MbozqFRILil22sPh1hpC9KnJmNLwKatLMXl7cB_NTOeCvzFYQeV8jUwG2oCI_RmD_WVwu7dni45VmzWsdxqiD4yNhm43aaHflLzAN5iMQ";
                requestTemplate.header(HttpHeaders.AUTHORIZATION,header);
            }
        }
    }
}
