package jvm.namecheck;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * Created by chuan on 2018/7/16.
 */
public class NameCheckProcessor extends AbstractProcessor {
    private NameChecker nameChecker;
    @Override
    public void  init(ProcessingEnvironment processingEnvironment){
        super.init(processingEnvironment);
        nameChecker=new NameChecker(processingEnvironment);
    }
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv){
        if(!roundEnv.processingOver()){
            for(Element element:roundEnv.getRootElements()){
                nameChecker.checkNames(element);
            }
        }
        return  false;
    }
}
