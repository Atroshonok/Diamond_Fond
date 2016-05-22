package by.pvt.atroshonok.diamondfond.builders;

public class PavilionBuilderFactory {
	private volatile static PavilionBuilderFactory uniqueFactory;
	
	private enum TypeParser {
		SAX, STAX, DOM, JSON
	}

	private PavilionBuilderFactory() {
	}
	
	public static PavilionBuilderFactory getInstance() {
		if (uniqueFactory == null) {
			synchronized (PavilionBuilderFactory.class) {
				if (uniqueFactory == null) {
					uniqueFactory = new PavilionBuilderFactory();
				}
			}
		}
		return uniqueFactory;
	}
	
	public AbstractPavilionBuilder createPavilionBuilder(String typeParser) {
		TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
		switch (type) {
		case DOM:
			return new PavilionDOMBuilder();
		case SAX:
			return new PavilionSAXBuilder();
		case STAX:
			return new PavilionStAXBuilder();
		case JSON:
			return new PavilionJSONBuilder();
		default:
			throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
		}
	}

}
