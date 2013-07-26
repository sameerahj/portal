package org.dhara.portal.web.codegen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: harsha
 * Date: 7/23/13
 * Time: 3:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class CodegenUtils {
    private List<String> methods=new ArrayList<String>();
    private List<String> imports=new ArrayList<String>();
    private String getOutputDataTypeMethod="public Class getOutputDataType(String identifier)";
    private String getInputDataTypeMethod="public Class getInputDataType(String identifier)";
    private String getOutputIdentifiersMethod="public List<String> getOutputIdentifiers()";
    private String getInputIdentifiersMethod="public List<String> getInputIdentifiers()";
    private String runMethod="public Map<String, IData> run(Map<String, List<IData>> inputMap)";
    private String literalImports="import org.n52.wps.io.data.binding.literal.*;";
    private String complexImports="import org.n52.wps.io.data.binding.complex.*;";
    private String algorithmImports="import org.n52.wps.server.*;";
    private String dataImports="import org.n52.wps.io.data*;";
    private String defailtPackage="package org.dhara.wps;";
    private String Class;
    public CodegenUtils() {
        setImports();
        setMethods();
    }

    private void setMethods() {
        methods.add(getInputDataTypeMethod);
        methods.add(getOutputDataTypeMethod);
        methods.add(getOutputIdentifiersMethod);
        methods.add(getInputIdentifiersMethod);
        methods.add(runMethod);
    }

    private void setImports() {
        imports.add(literalImports);
        imports.add(complexImports);
        imports.add(algorithmImports);
        imports.add(dataImports);
    }

    public String getDefailtPackage() {
        return defailtPackage;
    }

    public void setDefailtPackage(String defailtPackage) {
        this.defailtPackage = defailtPackage;
    }
}
