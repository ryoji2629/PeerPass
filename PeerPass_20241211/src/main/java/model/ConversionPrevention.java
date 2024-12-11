package model;

public class ConversionPrevention {
	
	public ConversionPrevention() {
    }
	
	public String change(String input) {
        if (input == null) {
            return null;
        }
        // 実態参照の逆（例：&lt; → <）
        return input.replace("&", "&amp;")
        			.replace("<", "&lt;")
        			.replace(">", "&gt;")
        			.replace("\"", "&quot;")
        			.replace("'", "&#39;");
    }
}
