/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatosBD;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Modelo.LineaDetalleHistoricoCompras;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author gabri
 */
public class ServicioHistoricoCompras extends servicio {
//    i,po,pd,p,d,h,m,a,numVuelo
      private static final String insertarHistoricoCompras = 
            "{call insertarHistoricoCompras(?,?,?,?,?,?,?,?,?)}";
      
    private static final String LISTARHISTORICOCOMPRAS = "{?=call listarHistoricoCompras(?)}";
    
    
    public void insertarHistoricoCompras(LineaDetalleHistoricoCompras linea)
    {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            try {
                throw new GlobalException("No se ha localizado el driver");
            } catch (GlobalException ex) {
                Logger.getLogger(ServicioHistoricoCompras.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } catch (SQLException e) {
            try {
                throw new NoDataException("La base de datos no se encuentra disponible");
            } catch (NoDataException ex) {
                Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;
        //    i,po,pd,p,d,h,m,a,numVuelo
        try {
            pstmt = conexion.prepareCall(insertarHistoricoCompras);
            pstmt.setString(1, linea.getIdentificacion());
            pstmt.setString(2, linea.getPaisOrigen());
            pstmt.setString(3, linea.getPaisDestino());
            pstmt.setString(4, linea.getPrecio());
            pstmt.setString(5, linea.getMes());
            pstmt.setString(6, linea.getDia());
            pstmt.setString(7, linea.getAnio());
            pstmt.setString(8, linea.getNumVuelo());
            pstmt.setString(9, linea.getHora());
            
            
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
            try {
                throw new GlobalException("Llave duplicada");
            } catch (GlobalException ex) {
                Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                try {
                    throw new GlobalException("Estatutos invalidos o nulos");
                } catch (GlobalException ex) {
                    Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public ArrayList<LineaDetalleHistoricoCompras> listarHistoricoCompras(String id)
    {
          try {
            conectar();
        } catch (ClassNotFoundException ex) {
              try {
                  throw new GlobalException("No se ha localizado el Driver");
              } catch (GlobalException ex1) {
                  Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex1);
              }
        } catch (SQLException e) {
              try {
                  throw new NoDataException("La base de datos no se encuentra disponible");
              } catch (NoDataException ex) {
                  Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
              }
        }

        ResultSet rs = null;
        ArrayList<LineaDetalleHistoricoCompras> coleccion = new ArrayList<>();
        LineaDetalleHistoricoCompras linea=null;
        CallableStatement pstmt = null;
        try {
            pstmt = conexion.prepareCall(LISTARHISTORICOCOMPRAS);
            pstmt.setString(2,id);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while (rs.next()) {
                linea = new LineaDetalleHistoricoCompras();
                linea.setIdentificacion(rs.getString("identificacion"));
                linea.setAnio(rs.getString("anio"));
                linea.setDia(rs.getString("dia"));
                linea.setHora(rs.getString("hora"));
                linea.setMes(rs.getString("mes"));
                linea.setPaisDestino(rs.getString("paisDestino"));
                linea.setPaisOrigen(rs.getString("paisOrigen"));
                linea.setPrecio("" + rs.getString("precio"));
                linea.setNumVuelo(rs.getString("numVuelo"));
                coleccion.add(linea);
            }
            coleccion.forEach((e) -> {
                System.out.println(e.toString()+"\n");
            });
        } catch (SQLException e) {
              try {
                  throw new GlobalException("Sentencia no valida");
              } catch (GlobalException ex) {
                  Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
              }
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                try {
                    throw new GlobalException("Estatutos invalidos o nulos");
                } catch (GlobalException ex) {
                    Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (coleccion == null || coleccion.isEmpty()) {
              try {
                  throw new NoDataException("No hay datos");
              } catch (NoDataException ex) {
                  Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
              }
        }
       
        return coleccion;
    }
    
    
    
    
    
    
     public ArrayList listarComprar() throws NoDataException
    {
          try {
            conectar();
        } catch (ClassNotFoundException ex) {
              try {
                  throw new GlobalException("No se ha localizado el Driver");
              } catch (GlobalException ex1) {
                  Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex1);
              }
        } catch (SQLException e) {
              try {
                  throw new NoDataException("La base de datos no se encuentra disponible");
              } catch (NoDataException ex) {
                  Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
              }
        }

        ResultSet rs = null;
        ArrayList<LineaDetalleHistoricoCompras> coleccion = new ArrayList<>();
        LineaDetalleHistoricoCompras linea=null;
        CallableStatement pstmt = null;
        try {
            pstmt = conexion.prepareCall(LISTARHISTORICOCOMPRAS);
//            pstmt.setString(2,numLineaDetalle);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
              while (rs.next()) {
                linea = new LineaDetalleHistoricoCompras();
                linea.setIdentificacion(rs.getString("identificacion"));
                linea.setAnio(rs.getString("anio"));
                linea.setDia(rs.getString("dia"));
                linea.setHora(rs.getString("hora"));
                linea.setMes(rs.getString("mes"));
                linea.setPaisDestino(rs.getString("paisDestino"));
                linea.setPaisOrigen(rs.getString("paisOrigen"));
                linea.setPrecio("" + rs.getString("precio"));
                linea.setNumVuelo(rs.getString("numVuelo"));
                coleccion.add(linea);
            }
            coleccion.forEach((e) -> {
                System.out.println(e.getIdentificacion()+"\n");
            });
        } catch (SQLException e) {
              try {
                  throw new GlobalException("Sentencia no valida");
              } catch (GlobalException ex) {
                  Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
              }
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                try {
                    throw new GlobalException("Estatutos invalidos o nulos");
                } catch (GlobalException ex) {
                    Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (coleccion == null || coleccion.isEmpty()) {
             
                  throw new NoDataException("No hay datos");
             
        }
        return coleccion;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
