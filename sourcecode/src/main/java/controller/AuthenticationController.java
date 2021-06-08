package controller;

import common.exception.ExpiredSessionException;
import common.exception.FailLoginException;
import dao.user.UserDAO;
import entity.user.User;
import utils.Utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;



/**
 * @author
 */
public class AuthenticationController extends BaseController {  //SOLID: vi pham nguyen tac LSP vi lop con AuthenticationController khong su dung 2 phuong thuc cua lop cha
	//Data coupling
	//Functional Conhesion
	final int HOURS = 24;
    public boolean isAnonymousSession() {
        try {
            getMainUser();
            return false;
        } catch (Exception ex) {
            return true;
        }
    }
    //Functional Conhesion
    //Content coupling vi thay doi du lieu bien mainUser, expiredTime mot cach truc tiep
    public User getMainUser() throws ExpiredSessionException {
    	//Data-Level Refactoring/Introduce an intermediate variable
    	final boolean isMainUserNotNull = SessionInformation.mainUser != null;
    	final boolean isExpiredTimeNotNull = SessionInformation.expiredTime != null;
    	final boolean isExpriredTimeBefore =  SessionInformation.expiredTime.isBefore(LocalDateTime.now());
        if (isMainUserNotNull || isExpiredTimeNotNull || isExpriredTimeBefore) {
            logout();
            throw new ExpiredSessionException();
        } else return SessionInformation.mainUser.cloneInformation();
    }
    //Functional Conhesion
    //    Content coupling do trực tiếp thay đổi dữ liệu của lớp SessionInformation
    public void login(String email, String password) throws Exception {
        try {
            User user = new UserDAO().authenticate(email, md5(password));
            if (Objects.isNull(user)) throw new FailLoginException();
            SessionInformation.mainUser = user;
            SessionInformation.expiredTime = LocalDateTime.now().plusHours(HOURS);
        } catch (SQLException ex) {
            throw new FailLoginException();
        }
    }
    //Functional Conhesion
    //Content coupling vi thay doi du lieu bien mainUser, expiredTime mot cach truc tiep
    public void logout() {
        SessionInformation.mainUser = null;
        SessionInformation.expiredTime = null;
    }

    /**
     * Return a {@link String String} that represents the cipher text
     * encrypted by md5 algorithm.
     *
     * @param message - plain text as {@link String String}.
     * @return cipher text as {@link String String}.
     */
    //Functional Conhesion
    //Data coupling
    private String md5(String message) {
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes(StandardCharsets.UTF_8));
            // converting byte array to Hexadecimal String
            StringBuilder sb = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }
            digest = sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Utils.getLogger(Utils.class.getName());
            digest = "";
        }
        return digest;
    }

}
