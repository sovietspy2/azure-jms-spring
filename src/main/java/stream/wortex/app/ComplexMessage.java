package stream.wortex.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComplexMessage implements Serializable {

    private String name;
    private Date createDate;
    private Integer age;
    private List<String> details = new ArrayList<>();

}
