/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatosBD;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Modelo.Fecha;
import Modelo.Horario;
import Modelo.Ruta;
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
public class servicioRuta extends servicio{
     //........... declaraciones de las variables con los nombres de los metodos en la base de datos.
    
    private static final String INSERTARRUTA = 
            "{call insertarRuta(?,?,?,?,?,?,?,?,?,?,?)}";
    private static final String ELIMINARRUTA = 
            "{call eliminarRuta(?)}";
    private static final String LISTARRUTAS = "{?=call listarRutas()}";
    private static final String CONSULTARRUTA = "{?=call consultarRuta(?)}";
    private static final String MODIFICARRUTA = "{call modificarRuta(?,?,?,?,?,?,?,?,?,?,?)}";
    
    //---------------------- F I N __ D E C L A R A C I Ó N ---------------
    
    public void insertarRuta(Ruta ruta) throws GlobalException
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
            pstmt = conexion.prepareCall(INSERTARRUTA);
            pstmt.setString(1, ruta.getIdentificador());
            pstmt.setString(2, ruta.getPaisOrigen());
            pstmt.setString(3, ruta.getPaisDestino());
            pstmt.setString(4, ruta.getHorario().getFechaSalida().getDia());
            pstmt.setString(5, ruta.getHorario().getFechaSalida().getHora());
            pstmt.setString(6, ruta.getHorario().getFechaSalida().getMes());
            pstmt.setString(7, ruta.getHorario().getFechaSalida().getAnio());
            pstmt.setString(8, ruta.getHorario().getFechaLLegada().getDia());
            pstmt.setString(9, ruta.getHorario().getFechaLLegada().getHora());
            pstmt.setString(10, ruta.getHorario().getFechaLLegada().getMes());
            pstmt.setString(11, ruta.getHorario().getFechaLLegada().getAnio());
            
            
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(servicioAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
           
                throw new GlobalException("Ese numero de ruta ya existe! , inserte otro");
            
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
    
    public void eliminarRuta(String id) throws GlobalException
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
            pstmt = conexion.prepareCall(ELIMINARRUTA);
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
            
                 throw new GlobalException("Esta Ruta se Encuentra en un vuelo , \n por lo tanto no se puede borrar"
                         + " hasta que se borre el vuelo que tiene esta ruta ligada...\n");
             
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
    
    public void modificarRuta(Ruta ruta)
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
            System.out.print("-> ruta modificada DAL 4  :  "+ruta.toString()+"\n");
            pstmt = conexion.prepareCall(MODIFICARRUTA);
            pstmt.setString(1, ruta.getIdentificador());
            pstmt.setString(2, ruta.getPaisOrigen());
            pstmt.setString(3, ruta.getPaisDestino());
            pstmt.setString(4, ruta.getHorario().getFechaSalida().getDia());
            pstmt.setString(5, ruta.getHorario().getFechaSalida().getHora());
            pstmt.setString(6, ruta.getHorario().getFechaSalida().getMes());
            pstmt.setString(7, ruta.getHorario().getFechaSalida().getAnio());
            pstmt.setString(8, ruta.getHorario().getFechaLLegada().getDia());
            pstmt.setString(9, ruta.getHorario().getFechaLLegada().getHora());
            pstmt.setString(10, ruta.getHorario().getFechaLLegada().getMes());
            pstmt.setString(11, ruta.getHorario().getFechaLLegada().getAnio());
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
    
    public ArrayList listarRutas()
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
        ArrayList<Ruta> coleccion = new ArrayList<>();
        Ruta linea = null;
        CallableStatement pstmt = null;
        Horario h = null;
        Fecha lle = null;
        Fecha sal = null;
        try {
            pstmt = conexion.prepareCall(LISTARRUTAS);
//            pstmt.setString(2,numLineaDetalle);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
           
            while (rs.next()) {
                sal=new Fecha();
                lle=new Fecha();
                sal.setDia(rs.getString("dias"));
                sal.setHora(rs.getString("horas"));
                sal.setMes(rs.getString("mess"));
                sal.setAnio(rs.getString("anios"));
                lle.setDia(rs.getString("dial"));
                lle.setHora(rs.getString("horal"));
                lle.setMes(rs.getString("mesl"));
                lle.setAnio(rs.getString("aniol"));
                h=new Horario();
                h.setFechaSalida(sal);
                h.setFechaLLegada(lle);
                linea= new Ruta(
                 rs.getString("identificador"),rs.getString("paisorigen")
                ,rs.getString("paisdestino"),h);
                coleccion.add(linea);
            }
            coleccion.forEach((e) -> {
                System.out.println(e.getPaisOrigen()+" -> "+e.getPaisDestino()+"\n");
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
    
    public Ruta consultarRuta(String id)
    {
             try {
            conectar();
        } catch (ClassNotFoundException ex) {
           System.out.print("No se ha localizado el Driver");
        } catch (SQLException e) {
            System.out.print("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        
        Ruta linea = null;
        CallableStatement pstmt = null;
        try {
            System.out.print("id a buscar en rutas : "+id+"\n");
            pstmt = conexion.prepareCall(CONSULTARRUTA);
            pstmt.setString(2, id);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            rs.next();
            Horario h = new Horario();
            Fecha lle = new Fecha();
            Fecha sal = new Fecha();
            sal.setDia(rs.getString("dias"));
            sal.setHora(rs.getString("horas"));
            sal.setMes(rs.getString("mess"));
            sal.setAnio(rs.getString("anios"));
            lle.setDia(rs.getString("dial"));
            lle.setHora(rs.getString("horal"));
            lle.setMes(rs.getString("mesl"));
            lle.setAnio(rs.getString("aniol"));
            h.setFechaSalida(sal);
            h.setFechaLLegada(lle);
            linea = new Ruta(
                    rs.getString("identificador"), rs.getString("paisorigen"),
                     rs.getString("paisdestino"), h);

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
