/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatosBD;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Modelo.LineaDetalleVuelo;
import Modelo.Vuelo;
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
public class servicioVuelo extends servicio {
    
    
    
    //........... declaraciones de las variables con los nombres de los metodos en la base de datos.
//    

    private static final String INSERTARVUELO = 
            "{call insertarVuelo(?,?,?,?,?)}";
    private static final String MODIFICARVUELO = 
            "{call modificarVuelo(?,?,?,?)}";
    private static final String LISTARVUELOS = "{?=call listarVuelos()}";
    private static final String CONSULTARVUELO = "{?=call consultarVuelo(?)}";
    private static final String ELIMINARVUELO = "{call eliminarVuelo(?)}";
    
    private static final String LISTARAVIONESDISPONIBLES = "{?=call listarAvionesDisponibles()}";
    
    //---------------------- F I N __ D E C L A R A C I Ó N ---------------
    
    
    public ArrayList<String> listarAvionesDisponibles() throws NoDataException
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
        ArrayList<String> coleccion = new ArrayList<>();
        String linea="";
        CallableStatement pstmt = null;
        try {
            pstmt = conexion.prepareCall(LISTARAVIONESDISPONIBLES);
//            pstmt.setString(2,numLineaDetalle);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while (rs.next()) {
               linea=rs.getString("identificacion");
                coleccion.add(linea);
            }
            coleccion.forEach((e) -> {
                System.out.println(e+"\n");
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
    
    //---------------------- F I N __ D E C L A R A C I Ó N ---------------
    
    public void insertarVuelo(Vuelo admin) 
    {
        try {
            conectar();
        } catch (ClassNotFoundException e) {
            try {
                throw new GlobalException("No se ha localizado el driver");
            } catch (GlobalException ex) {
                Logger.getLogger(servicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            try {
                throw new NoDataException("La base de datos no se encuentra disponible");
            } catch (NoDataException ex) {
                Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;
//create or replace procedure insertarVuelo(i in vuelos.identificacion%type,p in vuelos.precio%type
    //, idA in vuelos.idavion%type,
//idR in vuelos.idruta%type,t in vuelos.tipoVuelo%type)
        try {
            pstmt = conexion.prepareCall(INSERTARVUELO);
            pstmt.setString(1, admin.getIdentificacion());
            pstmt.setInt(2, admin.getPrecio());
            pstmt.setString(3, admin.getAvion().getIdentificacion());
            pstmt.setString(4, admin.getRuta().getIdentificador());
            pstmt.setString(5, admin.getTipoVuelo());
            
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
    
    public void eliminarVuelo(String id)
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
            pstmt = conexion.prepareCall(ELIMINARVUELO);
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
    
    public void modificarVuelo(Vuelo admin)
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
            
            
//    create or replace procedure modificarVuelo(i in vuelos.identificacion%type,p in vuelos.precio%type ,
//idR in vuelos.idruta%type,t in vuelos.tipoVuelo%type)
            
            pstmt = conexion.prepareCall(MODIFICARVUELO);
            
            pstmt.setString(1, admin.getIdentificacion());
            pstmt.setInt(2, admin.getPrecio());
            pstmt.setString(3, admin.getRuta().getIdentificador());
            pstmt.setString(4, admin.getTipoVuelo());
            
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
    
      public void modificarVuelo(String id,int precio,String idRut,String tipo)
    {
        
        System.out.print("Datos a Modificar : "+id+" , "+precio+" , "+idRut+" , "+tipo+" .\n");
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
            
            
//    create or replace procedure modificarVuelo(i in vuelos.identificacion%type,p in vuelos.precio%type ,
//idR in vuelos.idruta%type,t in vuelos.tipoVuelo%type)
            
            pstmt = conexion.prepareCall(MODIFICARVUELO);
            
            pstmt.setString(1, id);
            pstmt.setInt(2, precio);
            pstmt.setString(3, idRut);
            pstmt.setString(4, tipo);
            
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
    
    public ArrayList listarVuelos() throws NoDataException
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
        ArrayList<LineaDetalleVuelo> coleccion = new ArrayList<>();
        LineaDetalleVuelo linea=null;
        CallableStatement pstmt = null;
        try {
            pstmt = conexion.prepareCall(LISTARVUELOS);
//            pstmt.setString(2,numLineaDetalle);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while (rs.next()) {
                linea= new LineaDetalleVuelo();
                linea.setIdentificacion(rs.getString("identificacion"));
                linea.setPrecio(rs.getInt("precio"));
                linea.setTipoVuelo(rs.getString("tipovuelo"));
                linea.setPaisOrigen(rs.getString("paisorigen"));
                linea.setPaisDestino(rs.getString("paisdestino"));
                linea.setDiaSalida(rs.getString("dias"));
                linea.setMesSalida(rs.getString("mess"));
                linea.setAnioSalida(rs.getString("anios"));
                linea.setHoraSalida(rs.getString("horas"));
                linea.setDiaLlegada(rs.getString("dial"));
                linea.setMesLlegada(rs.getString("mesl"));
                linea.setAnioLlegada(rs.getString("aniol"));
                linea.setHoraLlegada(rs.getString("horal"));
                linea.setCantidadPasajeros(rs.getInt("cantidadpasajeros"));
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
    
    public LineaDetalleVuelo consultarVuelo(String id)
    {
             try {
            conectar();
        } catch (ClassNotFoundException ex) {
           System.out.print("No se ha localizado el Driver");
        } catch (SQLException e) {
            System.out.print("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        
            LineaDetalleVuelo linea=null;
        CallableStatement pstmt = null;
        try {
            pstmt = conexion.prepareCall(CONSULTARVUELO);
            pstmt.setString(2, id);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            rs.next();
            linea= new LineaDetalleVuelo();
                linea.setIdentificacion(rs.getString("identificacion"));
                linea.setPrecio(rs.getInt("precio"));
                linea.setTipoVuelo(rs.getString("tipovuelo"));
                linea.setPaisOrigen(rs.getString("paisorigen"));
                linea.setPaisDestino(rs.getString("paisdestino"));
                linea.setDiaSalida(rs.getString("dias"));
                linea.setMesSalida(rs.getString("mess"));
                linea.setAnioSalida(rs.getString("anios"));
                linea.setHoraSalida(rs.getString("horas"));
                linea.setDiaLlegada(rs.getString("dial"));
                linea.setMesLlegada(rs.getString("mesl"));
                linea.setAnioLlegada(rs.getString("aniol"));
                linea.setHoraLlegada(rs.getString("horal"));
                linea.setCantidadPasajeros(rs.getInt("cantidadpasajeros"));

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
