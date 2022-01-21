import java.util.List;

public interface GenericTable {
   
    List<String> getHeaders(String tableId);
    TableData getHeadersRow(String tableId);
    TableData getRow(int index,String tableId);
    List<TableData> getRows(String tableId);
}