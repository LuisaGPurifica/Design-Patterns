package faceted.builder;

import java.util.ArrayList;
import java.util.List;

class Exercise {
	public String name;
	public int age;
}

class CodeBuilder
{
    protected String className;
    protected List<Field> fields = new ArrayList<>();
    
    public CodeBuilder(String className)
    {
        this.className = className;
    }
    
    public CodeBuilder addField(String name, String type)
    {
        this.fields.add(new Field(name, type));
        return this;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(String.format("public class %s\n", this.className));

        sb.append("{\n");

        for (Field field : this.fields) {

            sb.append(String.format("  public %s %s;\n", field.type, field.name));

        }

        sb.append("}");

        return sb.toString();
    }
}

class Field {

    public String name;
    public String type;

    public Field(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
class Demo {
	public static void main(String[] args) {
		CodeBuilder cb = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
		System.out.println(cb);
	}
}
