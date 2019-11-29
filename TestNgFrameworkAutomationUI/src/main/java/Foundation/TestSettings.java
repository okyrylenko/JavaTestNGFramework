package Foundation;

import Foundation.Enums.Browsers;
import Foundation.Enums.Environments;
import com.google.common.base.Enums;
import lombok.Getter;
import lombok.Setter;

public class TestSettings {
    @Getter @Setter
    public static Environments env;

    @Getter @Setter
    public static Browsers browser;
}
