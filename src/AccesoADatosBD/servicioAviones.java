/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatosBD;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Modelo.Avion;
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
public class servicioAviones extends servicio{
    
    //........... declaraciones de las variables con los nombres de los metodos en la base de datos.
    private static final String INSERTARAVION = "{call insertarAvion(?,?,?,?,?)}";
    private static final String CONSULTARAVION = "{?=call consultarAvion(?)}";
    private static final String ELIMINARAVION = "{call eliminarAvion(?)}";
    private static final String LISTARAVIONES = "{?=call listarAviones()}";
    private static final String MODIFICARAVION = "{call modificarAvion(?,?,?,?,?)}";
    
    public void insertarAvion(Avion admin) 
    {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            try {
                throw new GlobalException("No se ha localizado el driver");
            } catch (GlobalException ex) {
                Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            try {
                throw new NoDataException("La base de datos no se encuentra disponible");
            } catch (NoDataException ex) {
                Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(INSERTARAVION);
            
//     insertarAvion(i in aviones.identificacion%type,a in aviones.anio%type,m in aviones.modelo%type,
//marc in aviones.marca%type,cnt in aviones.cantidadpasajeros%type)
    //values(i,a,m,marc,cnt);
            pstmt.setString(1, admin.getIdentificacion());
            pstmt.setString(2, admin.getAnio());
            pstmt.setString(3, admin.getModelo());
            pstmt.setString(4, admin.getMarca());
            pstmt.setInt(5, admin.getCantidadPasajeros());
            
            
            
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
    
    public void eliminarAvion(String id) throws GlobalException
    {
         try {
            conectar();
        } catch (ClassNotFoundException e) {
             try {
                 throw new GlobalException("No se ha localizado el driver");
             } catch (GlobalException ex) {
                 Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
             }
        } catch (SQLException e) {
             try {
                 throw new NoDataException("La base de datos no se encuentra disponible");
             } catch (NoDataException ex) {
                 Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(ELIMINARAVION);
            pstmt.setString(1,id);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
           throw new GlobalException("Ese Avion esta Ligado a un Vuelo\n");
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
    
    public void modificarAvion(Avion ruta)
    {   
       try {
            conectar();
        } catch (ClassNotFoundException e) {
              try {
                  throw new GlobalException("No se ha localizado el driver");
              } catch (GlobalException ex) {
               Logger.getLogger(servicioAviones.class.getName()).log(Level.SEVERE, null, ex);
           }
        } catch (SQLException e) {
              try {
                  throw new NoDataException("La base de datos no se encuentra disponible");
              } catch (NoDataException ex) {
               Logger.getLogger(servicioAviones.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        CallableStatement pstmt = null;

        try {
//             modificarAvion(i in aviones.identificacion%type,a in aviones.anio%type , m in aviones.modelo%type
//,mar in aviones.marca%type, cant in aviones.cantidadpasajeros%type)
            pstmt = conexion.prepareCall(MODIFICARAVION);
            pstmt.setString(1, ruta.getIdentificacion());
            pstmt.setString(2, ruta.getAnio());
            pstmt.setString(3, ruta.getModelo());
            pstmt.setString(4, ruta.getMarca());
            pstmt.setInt(5, ruta.getCantidadPasajeros());
//            System.out.print(ruta.toString()+"\n");
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(servicioAviones.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
              try {
                  throw new GlobalException("Llave duplicada");
              } catch (GlobalException ex) {
               Logger.getLogger(servicioAviones.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(servicioAviones.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
   
    
    public ArrayList<Avion> listarAviones()
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
        ArrayList<Avion> coleccion = new ArrayList<>();
        Avion linea=null;
        CallableStatement pstmt = null;
        try {
            pstmt = conexion.prepareCall(LISTARAVIONES);
//            pstmt.setString(2,numLineaDetalle);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while (rs.next()) {
                linea= new Avion(
                 rs.getString("identificacion")
                ,rs.getString("anio")
                ,rs.getString("modelo")
                ,rs.getString("marca"));
                linea.setCantidadPasajeros(rs.getInt("cantidadPasajeros"));
                coleccion.add(linea);
            }
            coleccion.forEach((e) -> {
                System.out.println(e.getIdentificacion()+", pasajeros : "+e.getCantidadPasajeros()+"\n");
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
    
    public Avion consultarAvion(String id)
    {
             try {
            conectar();
        } catch (ClassNotFoundException ex) {
           System.out.print("No se ha localizado el Driver");
        } catch (SQLException e) {
            System.out.print("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        
        Avion linea = null;
        CallableStatement pstmt = null;
        try {
            pstmt = conexion.prepareCall(CONSULTARAVION);
            pstmt.setString(2, id);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            rs.next();
            
                linea= new Avion(
                 rs.getString("identificacion")
                ,rs.getString("anio")
                ,rs.getString("modelo")
                ,rs.getString("marca"));
                linea.setCantidadPasajeros(
                rs.getInt("cantidadpasajeros"));

        } catch (SQLException e) {
            e.printStackTrace();            
            System.out.print("Sentencia no valida");
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
                System.out.print("Estatutos invalidos o nulos");
            }
        }
    
        return linea;
    }

    
    
    
}
