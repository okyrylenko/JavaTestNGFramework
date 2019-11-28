package Foundation.dataRepository;


import Foundation.models.Account;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FilenameUtils;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class DataProvider {

    public static List<Account> getAccounts() throws IOException {
        String s  = System.getProperty("user.dir");
        return Arrays.asList(getData(FilenameUtils.separatorsToSystem(s +"\\src\\main\\java\\Foundation\\dataRepository\\Account.json"), Account[].class));
    }
    private static <T> T getData(String path, Class<T> cls) throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get((path)));
        return (T) new ObjectMapper().readValue(jsonData, cls);
    }
}
