package com.capricove.capricove.backend.data;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TokenGenerator {

    public String generateToken(){
        Random rnd = new Random();
        char[] buf = new char[128];
        for (int i = 0; i < buf.length; i++)
            buf[i] = (char)(33 + rnd.nextInt(127 - 33));

        return String.valueOf(buf);
    }


}
