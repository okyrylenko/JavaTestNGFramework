package Foundation.dataRepository;


import Foundation.models.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FilenameUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class DataSupplier {

    @DataProvider(name =DataProvidersFactory.allAccounts)
    public static Iterator<Object> getAccounts() throws IOException {
        return convertToIterator(Arrays.asList(getData(FilenameUtils.separatorsToSystem(System.getProperty("user.dir") +"\\src\\main\\java\\Foundation\\dataRepository\\dataStorage\\Account.json"), Account[].class)));
    }

    private static <T> T getData(String path, Class<T> cls) throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get((path)));
        return (T) new ObjectMapper().readValue(jsonData, cls);
    }

    private static <T> Iterator<Object> convertToIterator(List<T> data){
        Collection<Object> toReturn = new ArrayList<Object>();
        for(T item : data){
            toReturn.add(item);
        }

        return toReturn.iterator();
    }
}
