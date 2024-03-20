/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatosBD;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Modelo.Administrador;
import Modelo.Fecha;
import Modelo.LineaDetalleAdministrador;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

public class servicioAdministrador extends servicio {

    //........... declaraciones de las variables con los nombres de los metodos en la base de datos.
    private static final String INSERTARADMINISTRADOR = 
            "{call insertarAdministrador(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    private static final String MODIFICARADMINISTRADOR = 
            "{call modificarAdministrador(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    private static final String LISTARADMINISTRADORES = "{?=call listarAdministradores()}";
    private static final String CONSULTARADMINISTRADOR = "{?=call consultarAdministrador(?)}";
    private static final String ELIMINARADMINISTRADOR = "{call eliminarAdministrador(?)}";
    
    //---------------------- F I N __ D E C L A R A C I Ó N ---------------
    
    public void insertarAdministrador(Administrador admin) 
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
            pstmt = conexion.prepareCall(INSERTARADMINISTRADOR);
            pstmt.setString(1, admin.getFechaNacimiento().getDia());
            pstmt.setString(2, admin.getFechaNacimiento().getHora());
            pstmt.setString(3, admin.getFechaNacimiento().getMes());
            pstmt.setString(4, admin.getFechaNacimiento().getAnio());
            pstmt.setString(5, admin.getIdentificacion());
            pstmt.setString(6, admin.getContrasenia());
            pstmt.setString(7, admin.getNombre());
            pstmt.setString(8, admin.getApellido1());
            pstmt.setString(9, admin.getApellido2());
            pstmt.setString(10, admin.getCorreoElectronico());
            pstmt.setString(11, admin.getDireccion());
            pstmt.setString(12, admin.getTipoUsuario());
            pstmt.setString(13, admin.getTelefonoTrabajo());
            pstmt.setString(14, admin.getCelular());
            
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
    
    public void eliminarAdministrador(String id)
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
            pstmt = conexion.prepareCall(ELIMINARADMINISTRADOR);
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
    
    public void modificarAdministrador(Administrador admin)
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
            pstmt = conexion.prepareCall(MODIFICARADMINISTRADOR);
            pstmt.setString(1, admin.getFechaNacimiento().getDia());
            pstmt.setString(2, admin.getFechaNacimiento().getHora());
            pstmt.setString(3, admin.getFechaNacimiento().getMes());
            pstmt.setString(4, admin.getFechaNacimiento().getAnio());
            pstmt.setString(5, admin.getIdentificacion());
            pstmt.setString(6, admin.getContrasenia());
            pstmt.setString(7, admin.getNombre());
            pstmt.setString(8, admin.getApellido1());
            pstmt.setString(9, admin.getApellido2());
            pstmt.setString(10, admin.getCorreoElectronico());
            pstmt.setString(11, admin.getDireccion());
            pstmt.setString(12, admin.getTipoUsuario());
            pstmt.setString(13, admin.getTelefonoTrabajo());
            pstmt.setString(14, admin.getCelular());
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
    
    
    
    
    
    public ArrayList<LineaDetalleAdministrador> listarAdministradores()
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
        ArrayList<LineaDetalleAdministrador> coleccion = new ArrayList<>();
        LineaDetalleAdministrador linea=null;
        CallableStatement pstmt = null;
        try {
            pstmt = conexion.prepareCall(LISTARADMINISTRADORES);
//            pstmt.setString(2,numLineaDetalle);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while (rs.next()) {
                linea= new LineaDetalleAdministrador(
                 rs.getString("identificacion")
                ,rs.getString("nombre")
                ,rs.getString("apellido1")
                ,rs.getString("apellido2")
                ,rs.getString("celular")
                ,rs.getString("contrasenia"));
                coleccion.add(linea);
            }
           
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
    
    
    
    
    
    public Administrador consultarAdministrador(String id)
    {
             try {
            conectar();
        } catch (ClassNotFoundException ex) {
           System.out.print("No se ha localizado el Driver");
        } catch (SQLException e) {
            System.out.print("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        
        Administrador linea = null;
        CallableStatement pstmt = null;
        try {
            pstmt = conexion.prepareCall(CONSULTARADMINISTRADOR);
            pstmt.setString(2, id);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            rs.next();
            Fecha d=new Fecha();
            d.setAnio(rs.getString("anio"));
            d.setDia(rs.getString("hora"));
            d.setHora(rs.getString("dia"));
            d.setMes(rs.getString("mes"));
            linea= new Administrador(
                rs.getString("identificacion")
                ,rs.getString("contrasenia")
                ,rs.getString("nombre")
                ,rs.getString("apellido1")
                ,rs.getString("apellido2")
                ,rs.getString("correoelectronico")
                ,d
                ,rs.getString("direccion")
                ,rs.getString("tipousuario")
                ,rs.getString("telefono")    
                ,rs.getString("celular")
            );

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
